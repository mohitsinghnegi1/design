#include <iostream>
#include <map>
#include <list>

using namespace std;

namespace com
{
    namespace framework
    {
        namespace api
        {
            class Object
            {
            };

            class Factory : public Object
            {
            public:
                virtual Object *get(string key) = 0;
            };

            class Repository : public Object
            {
            public:
                virtual void create(int key, Object *value) = 0;
                virtual Object *read(int key) = 0;
            };

            class Menu : public Object
            {
            public:
                virtual void display() = 0;
            };

            class MenuItem : public Object
            {
            public:
                virtual string getLabel() = 0;
                virtual bool onSelect() = 0;
            };
        }
        namespace service
        {
            using namespace api;
            class InMemoryRepository : public Repository
            {
            private:
                map<int, Object *> entries;
                static InMemoryRepository *INSTANCE;
                InMemoryRepository() {}

            public:
                static InMemoryRepository *getInstance()
                {
                    if (INSTANCE == nullptr)
                        INSTANCE = new InMemoryRepository();
                    return INSTANCE;
                }
                void create(int key, Object *value)
                {
                    entries.insert(pair<int, Object *>(key, value));
                }
                Object *read(int key)
                {
                    if (entries.count(key) < 1)
                        return nullptr;
                    return entries.at(key);
                }
            };

            InMemoryRepository *InMemoryRepository::INSTANCE = nullptr;
        }
    }
}

namespace com
{
    namespace dir
    {
        using namespace com::framework::api;
        using namespace com::framework::service;
        namespace api
        {

            class User : public Object
            {
            private:
                string name;
                long phone;

            public:
                User(string name, long phone)
                {
                    this->name = name;
                    this->phone = phone;
                }

                string getName()
                {
                    return name;
                }

                long getPhone()
                {
                    return phone;
                }
            };

            class Directory : public Object
            {
            public:
                virtual User *add(User *e) = 0;
                virtual User *find(long phone) = 0;
            };

            class DirectoryException
            {
            private:
                string message;

            public:
                DirectoryException(string msg)
                {
                    message = msg;
                }
                string getMessage()
                {
                    return message;
                }
            };

            class InvalidUserException : public DirectoryException
            {
            public:
                InvalidUserException(string msg) : DirectoryException(msg)
                {
                }
            };

            class UserNotFoundException : public DirectoryException
            {
            public:
                UserNotFoundException(string msg) : DirectoryException(msg)
                {
                }
            };

        }

        namespace service
        {
            using namespace com::dir::api;

            class SimpleDirectory : public Directory
            {
            private:
                Repository *repo;

            public:
                SimpleDirectory(Repository *repo)
                {
                    this->repo = repo;
                }
                User *add(User *user)
                {
                    if (user->getPhone() < 0)
                        throw new InvalidUserException("Invalid phone");
                    repo->create(user->getPhone(), user);
                    return user;
                }
                User *find(long phone)
                {
                    User *user = (User *)repo->read(phone);
                    if (user == nullptr)
                        throw new UserNotFoundException("User not found");
                    return user;
                }
            };

            class ValidatableDirectory : public Directory
            {
            private:
                Directory *target;

            public:
                ValidatableDirectory(Directory *target)
                {
                    this->target = target;
                }
                User *add(User *user)
                {
                    if (user->getPhone() < 0)
                        throw new InvalidUserException("Invalid phone");
                    return this->target->add(user);
                }
                User *find(long phone)
                {
                    return this->target->find(phone);
                }
            };

            class LoggableDirectory : public Directory
            {
            private:
                Directory *target;

            public:
                LoggableDirectory(Directory *target)
                {
                    this->target = target;
                }
                User *add(User *user)
                {
                    cout << "Entering add()" << endl;
                    try
                    {
                        User *result = this->target->add(user);
                        cout << "Leaving add()" << endl;
                        return result;
                    }
                    catch (DirectoryException e)
                    {
                        cout << "Exiting add() with error" << endl;
                        throw e;
                    }
                }
                User *find(long phone)
                {
                    cout << "Entering find()" << endl;
                    try
                    {
                        User *result = this->target->find(phone);
                        cout << "Leaving find()" << endl;
                        return result;
                    }
                    catch (DirectoryException e)
                    {
                        cout << "Exiting find() with error" << endl;
                        throw e;
                    }
                }
            };

            class PrintableDirectory : public Directory
            {
            private:
                Directory *target;

            public:
                PrintableDirectory(Directory *target)
                {
                    this->target = target;
                }
                User *add(User *user)
                {
                    return this->target->add(user);
                }
                User *find(long phone)
                {
                    return this->target->find(phone);
                }
                void print(long phone)
                {
                    User *user = this->find(phone);
                    cout << "Name: " << user->getName() << " and Phone: " << user->getPhone() << endl;
                }
            };
        }
    }
}

namespace com
{
    namespace client
    {
        using namespace com::framework::api;
        using namespace com::framework::service;
        using namespace com::dir::api;
        using namespace com::dir::service;

        class ObjectFactory : public Factory
        {
        private:
            map<int, string> config;

        public:
            ObjectFactory(map<int, string> config)
            {
                this->config = config;
            }
            Object *get(string key)
            {
                if (key == "dir")
                {
                    Repository *repo = (Repository *)get("repo");
                    Directory *target = new SimpleDirectory(repo);
                    int count = 0;
                    while (count < this->config.size())
                    {
                        string feature = this->config.at(count);
                        if (feature == "logging")
                            target = new LoggableDirectory(target);
                        if (feature == "validation")
                            target = new ValidatableDirectory(target);
                        count++;
                    }
                    return target;
                }

                if (key == "repo")
                {
                    return InMemoryRepository::getInstance();
                }

                throw new DirectoryException("Object not available");
            }
        };

        class ExitMenuItem : public MenuItem
        {
        public:
            string getLabel()
            {
                return "Exit";
            }

            bool onSelect()
            {
                cout << "Thank You" << endl;
                return false;
            }
        };

        class AddMenuItem : public MenuItem
        {
        private:
            Directory *dir;

        public:
            AddMenuItem(Directory *dir)
            {
                this->dir = dir;
            }
            string getLabel()
            {
                return "Add User";
            }

            bool onSelect()
            {
                string name;
                long phone;

                cout << "Name: ";
                cin >> name;
                cout << "Phone: ";
                cin >> phone;

                User *user = new User(name, phone);
                try
                {
                    this->dir->add(user);
                    cout << "Added user successfully" << endl;
                }
                catch (InvalidUserException *e)
                {
                    cout << e->getMessage() << endl;
                }

                return true;
            }
        };

        class FindMenuItem : public MenuItem
        {
        private:
            PrintableDirectory *pdir;

        public:
            FindMenuItem(Directory *dir)
            {
                this->pdir = new PrintableDirectory(dir);
            }
            string getLabel()
            {
                return "Find User";
            }

            bool onSelect()
            {
                long phone;

                cout << "Phone: ";
                cin >> phone;

                try
                {
                    this->pdir->print(phone);
                }
                catch (UserNotFoundException *e)
                {
                    cout << e->getMessage() << endl;
                }
                return true;
            }
        };

        class SimpleMenu : public Menu
        {
        private:
            map<int, MenuItem *> items;
            SimpleMenu()
            {
            }

        public:
            void display()
            {
                bool proceed = true;
                while (proceed)
                {
                    int count = 0;
                    cout << "Choose: ";
                    while (count < items.size())
                    {
                        cout << (count + 1) << ") " << items.at(count)->getLabel() << " ";
                        count++;
                    }
                    cout << " : ";
                    int option;
                    cin >> option;
                    proceed = items.at(option - 1)->onSelect();
                }
            }
            class MenuBuilder;
        };

        class SimpleMenu::MenuBuilder
        {
        private:
            map<int, MenuItem *> items;
            int id;

        public:
            MenuBuilder()
            {
                id = 0;
            }
            MenuBuilder *add(MenuItem *item)
            {
                items.insert(pair<int, MenuItem *>(id, item));
                id++;
                return this;
            }
            SimpleMenu *build()
            {
                items.insert(pair<int, MenuItem *>(id, new ExitMenuItem()));
                SimpleMenu *menu = new SimpleMenu();
                menu->items = items;
                return menu;
            }
        };
    }
}

int main()
{
    using namespace com::framework::api;
    using namespace com::framework::service;
    using namespace com::dir::api;
    using namespace com::dir::service;
    using namespace com::client;

    try
    {
        map<int, string> config;
        config.insert(pair<int, string>(0, "logging"));
        config.insert(pair<int, string>(1, "validation"));

        Factory *factory = new ObjectFactory(config);
        Directory *dir = (Directory *)factory->get("dir");
        Menu *menu = (new SimpleMenu::MenuBuilder())
                         ->add(new AddMenuItem(dir))
                         ->add(new FindMenuItem(dir))
                         ->build();
        menu->display();
    }
    catch (DirectoryException *d)
    {
        cout << d->getMessage() << endl;
    }
    return 0;
}