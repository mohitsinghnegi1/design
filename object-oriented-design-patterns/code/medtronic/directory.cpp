#include <iostream>
#include <map>
#include <chrono>
#include <ctime> 
using namespace std;

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

class Object {

};

class Factory
{
    public:
        virtual Object* get(string key) = 0;
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

class Auditor : public Directory
{
    private: 
        Directory* target;

    public:
        Auditor(Directory* target)
        {
            this->target = target;
        }

        Employee* add(Employee e) {
            try
            {
                cout << "auditor::adding employee" << endl;
                Employee* ret = this->target->add(e);
                cout << "auditor::added employee" << endl;
                return ret;
            }
            catch (const char* e)
            {
                cout << "auditor::adding failed: " << e << endl;
                throw e;
            }
        }
        Employee* find(int eid) {
            try
            {
                cout << "auditor::finding employee" << endl;
                Employee* ret = this->target->find(eid);
                cout << "auditor::found employee" << endl;
                return ret;

            }
            catch (const char* e)
            {
                cout << "auditor::find failed: " << e << endl;
                throw e;

            }
        }
};

class Monitor : public Directory
{
    private: 
        Directory* target;

    public:
        Monitor(Directory* target)
        {
            this->target = target;
        }

        Employee* add(Employee e) {
            try
            {
                // start time
                Employee* ret = this->target->add(e);
                // end time
                // print the duration
                return ret;
            }
            catch (const char* e)
            {
                // end time
                // print the duration
                throw e;
            }
        }
        Employee* find(int eid) {
            try
            {
                // start time
                Employee* ret = this->target->find(eid);
                // end time
                // print the duration
                return ret;
            }
            catch (const char* e)
            {
                // end time
                // print the duration
                throw e;
            }
        }
};

class PrintableDirectory : public Directory
{
    private: 
        Directory* target;

    public:
        PrintableDirectory(Directory* target)
        {
            this->target = target;
        }

        Employee* add(Employee e) {
            return this->target->add(e);
        }
        Employee* find(int eid) {
            return this->target->find(eid);
        }
        void print(int eid) {
            Employee* e = this->target->find(eid);
            cout << e->getName() << "[" << e->getPhone() << "]" << endl;
        }
};

class ObjectFactory : public Factory
{
    private: 
        bool auditor;
        bool monitor;
    public:
        ObjectFactory(bool auditor, bool monitor)
        {
            this->auditor = auditor;
            this->monitor = monitor;
        }
        Object* get(string key)
        {
            if(key == "directory")
            {
                Storage* storage = (Storage*) this->get("storage");
                Directory* dir = new SimpleDirectory(storage);
                if(auditor == true)
                {
                    dir = new Auditor(dir);
                }
                if(monitor == true)
                {
                    dir = new Monitor(dir);
                }
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
        Factory* factory = new ObjectFactory(true, true);
        Directory* dir = (Directory*) factory->get("directory");
        Employee* e = dir->add(Employee("Krishna", 1234, "Bengaluru", "a@b.com"));
        PrintableDirectory* pdir = new PrintableDirectory(dir);
        pdir->print(10);
    }
    catch (const char* e)
    {
        cout << e << endl;
    }
    return 0;
}