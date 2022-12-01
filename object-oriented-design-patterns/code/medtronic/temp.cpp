#include <iostream>
#include <map>
using namespace std;

class Object {

};

class Factory
{
    public:
        virtual Object* get(string key) = 0;
};

class Employee 
{
    private:
        int eid;
        string name;
        long phone;
        string address;
        string email;
    public:
        Employee(string name, long phone, string address, string email)
        {
            this->name = name;
            this->phone = phone;
            this->address = address;
            this->email = email;
        }
        Employee(int eid, string name, long phone, string address, string email)
        {
            this->eid = eid;
            this->name = name;
            this->phone = phone;
            this->address = address;
            this->email = email;
        }
        int getEid(){
            return eid;
        }
        string getName(){
            return name;
        }
        long getPhone(){
            return phone;
        }
        string getAddress(){
            return address;
        }
        string getEmail() {
            return email;
        }
};

class Directory: public Object
{
    public:
        virtual Employee* add(Employee employee) = 0;
        virtual Employee* find(int eid) = 0;
};

class Storage: public Object
{
    public:
        virtual Employee* save(Employee* e) = 0;
        virtual Employee* fetch(int eid) = 0;
};

class InMemoryStorage : public Storage
{
    private: 
        map<int, Employee*> employees;

    public:
        Employee* save(Employee* e) {
            employees[e->getEid()] = e;
            return e;
        }
        Employee* fetch(int eid) {
            map<int,Employee*>::iterator it = employees.find(eid);
            if(it == employees.end())
                return NULL;
            return it->second;
        }
};

class SimpleDirectory : public Directory
{
    private: 
        Storage* storage;
        int id;

    public:
        SimpleDirectory(Storage* storage)
        {
            this->storage = storage;
            this->id = 0;
        }

        Employee* add(Employee e) {
            if(e.getPhone() < 0)
                throw "Invalid Employee";

            Employee* emp = storage->save(new Employee(++id, e.getName(), e.getPhone(), e.getAddress(), e.getEmail()));
            return emp;
        }
        Employee* find(int eid) {
            Employee* emp = storage->fetch(eid);
            if(emp == NULL)
                throw "Not found";
            return emp;
        }
};

class ObjectFactory : public Factory
{
public:
    Object* get(string key)
    {
        if(key == "directory")
        {
            Storage* storage = (Storage*) this->get("storage");
            Directory* dir = new SimpleDirectory(storage);
            return dir;
        }
        if(key == "storage")
        {
            return new InMemoryStorage();
        }
        throw "Failed to get object";
    }
};

int main()
{
    try
    {
        Factory* factory = new ObjectFactory();
        Directory* dir = (Directory*) factory->get("directory");
        Employee* e = dir->add(Employee("Krishna", 1234, "Bengaluru", "a@b.com"));
        cout << "Added a new employee with ID: " << e->getEid() << endl;
        Employee* result = dir->find(1);
        cout << "Found an employee with name: " << result->getName() << endl;
    }
    catch (const char* e)
    {
        cout << e << endl;
    }
    return 0;
}