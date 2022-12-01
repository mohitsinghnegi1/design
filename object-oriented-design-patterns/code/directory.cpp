#include <iostream>
using namespace std;

class Object 
{

};

class User 
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
};

class Directory 
{
    public:
        virtual User add(User user) = 0;
        virtual User find(long phone) = 0;
};

class Repository 
{
    public:
        virtual User create(User user) = 0;
        virtual User read(long phone) = 0;
};

class Factory
{
    public:
        virtual Object* get(string key) = 0;
};

class Menu
{
    public:
        virtual void display() = 0;
};

class MenuItem
{
    public:
        virtual string getLabel() = 0;
        virtual string onSelect() = 0;
};

class InMemoryRepository : public Repository
{
    private:
        static InMemoryRepository *INSTANCE;
        InMemoryRepository()
        {

        }
    public:
        static InMemoryRepository getInstance()
        {
            if(INSTANCE == nullptr)
            {
                INSTANCE = new InMemoryRepository();
            }
        }
        User create(User user)
        {
            return user;
        }
        
        User read(long phone)
        {
            throw "Not Found";
        }
};

class SimpleDirectory : public Directory 
{
    private:
        Repository* repo;
    public:
        SimpleDirectory(Repository* repo)
        {
            this->repo = repo;
        }

        User add(User user)
        {
            return this->repo->create(user);
        }

        User find(long phone)
        {
            return this->repo->read(phone);
        }
};

class ObjectFactory : public Factory
{
public:
    Object* get(string key)
    {
        if (key == "directory")
        {
            return new SimpleDirectory();
        }

        if (key == "repo")
        {
            return InMemoryRepository::getInstance();
        }

        throw "Object not available";
    }
};

int main()
{
    try
    {
        Component* component = Factory::get("component");
        component->service();
    }
    catch (const char* e)
    {
        cout << e << endl;
    }
    return 0;
}