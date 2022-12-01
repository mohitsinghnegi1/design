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
    namespace lib
    {
        using namespace com::framework::api;
        using namespace com::framework::service;
        namespace api
        {

            class Book : public Object
            {
            private:
                int isbn;
                string title;
                double price;
                list<string> authors;
                string publisher;
                Book(int isbn, string title)
                {
                    this->isbn = isbn;
                    this->title = title;
                }
                void setPrice(double price)
                {
                    this->price = price;
                }
                void addAuthor(string author)
                {
                    this->authors.push_back(author);
                }
                void setPublisher(string publisher)
                {
                    this->publisher = publisher;
                }
            public:
                int getISBN()
                {
                    return isbn;
                }

                string getTitle()
                {
                    return title;
                }

                list<string> getAuthors()
                {
                    return authors;
                }

                string getPublisher()
                {
                    return publisher;
                }

                double getPrice()
                {
                    return price;
                }
            };

            class Library : public Object
            {
            public:
                virtual Book *add(Book *e) = 0;
                virtual Book *find(int isbn) = 0;
            };

            class LibraryException
            {
            private:
                string message;

            public:
                LibraryException(string msg)
                {
                    message = msg;
                }
                string getMessage()
                {
                    return message;
                }
            };

            class InvalidBookException : public LibraryException
            {
            public:
                InvalidBookException(string msg) : LibraryException(msg)
                {
                }
            };

            class BookNotFoundException : public LibraryException
            {
            public:
                BookNotFoundException(string msg) : LibraryException(msg)
                {
                }
            };

        }

        namespace service
        {
            using namespace com::lib::api;

            class SimpleLibrary : public Library
            {
            private:
                Repository *repo;

            public:
                SimpleLibrary(Repository *repo)
                {
                    this->repo = repo;
                }
                Book *add(Book *book)
                {
                    if (book->getISBN() < 0)
                        throw new InvalidBookException("Invalid ISBN");
                    repo->create(book->getISBN(), book);
                    return book;
                }
                Book *find(int isbn)
                {
                    Book *book = (Book *)repo->read(isbn);
                    if (book == nullptr)
                        throw new BookNotFoundException("Book not found");
                    return book;
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
        using namespace com::lib::api;
        using namespace com::lib::service;

        class ObjectFactory : public Factory
        {
        public:
            Object *get(string key)
            {
                if (key == "lib")
                {
                    Repository *repo = (Repository *)get("repo");
                    return new SimpleLibrary(repo);
                }

                if (key == "repo")
                {
                    return InMemoryRepository::getInstance();
                }

                throw new LibraryException("Object not available");
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
            Library *lib;

        public:
            AddMenuItem(Library *lib)
            {
                this->lib = lib;
            }
            string getLabel()
            {
                return "Add Book";
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
            Library *dir;

        public:
            FindMenuItem(Library *dir)
            {
                this->dir = dir;
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
                    User *user = this->dir->find(phone);
                    cout << "Found " << user->getName() << endl;
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
        Factory *factory = new ObjectFactory();
        Library *dir = (Library *)factory->get("dir");
        Menu *menu = (new SimpleMenu::MenuBuilder())
                         ->add(new AddMenuItem(dir))
                         ->add(new FindMenuItem(dir))
                         ->build();
        menu->display();
    }
    catch (LibraryException *d)
    {
        cout << d->getMessage() << endl;
    }
    return 0;
}