#include <iostream>
#include <map>
#include <list>

using namespace std;

// global
class Object
{
};

// auditor

class Auditor : public Object
{
public:
    virtual void log(string record) = 0;
};

class SimpleAuditor : public Auditor
{
public:
    void log(string record)
    {
        cout << "Auditor: " << record << endl;
    }
};

// notifier

class Notifier : public Object
{
public:
    virtual void notify(string message) = 0;
};

class EmailNotifier : public Notifier
{
public:
    void notify(string message)
    {
        cout << "Mailer: " << message << endl;
    }
};

// broker

class Message : public Object
{
private:
    string topic;
    string body;

public:
    Message(string header, string payload)
    {
        topic = header;
        body = payload;
    }

    string getTopic()
    {
        return topic;
    }

    string getBody()
    {
        return body;
    }
};

class Handler : public Object
{
public:
    virtual void handle(Message *message) = 0;
    virtual string getId() = 0;
    virtual string getTopic() = 0;
};

class Broker : public Object
{
public:
    virtual void subscribe(Handler *handler) = 0;
    virtual void unsubscribe(string id) = 0;
    virtual void publish(Message *message) = 0;
};

class MessageBroker : public Broker
{
private:
    static MessageBroker *INSTANCE;
    MessageBroker() {}
    list<Handler *> handlers;

public:
    static MessageBroker *getInstance()
    {
        if (INSTANCE == nullptr)
            INSTANCE = new MessageBroker();
        return INSTANCE;
    }

    void subscribe(Handler *handler)
    {
        handlers.push_back(handler);
    }

    void unsubscribe(string id)
    {
        // TBD
    }

    void publish(Message *message)
    {
        list<Handler *>::iterator it;
        for (it = handlers.begin(); it != handlers.end(); it++)
        {
            (*it)->handle(message);
        }
    }
};

MessageBroker* MessageBroker::INSTANCE = nullptr;

// cache

class Cache : public Object
{
public:
    virtual void put(int key, Object *value) = 0;
    virtual Object *get(int key) = 0;
};

class MapCache : public Cache
{
private:
    map<int, Object *> entries;
    static MapCache *INSTANCE;
    MapCache() {}

public:
    static MapCache *getInstance()
    {
        if (INSTANCE == nullptr)
            INSTANCE = new MapCache();
        return INSTANCE;
    }
    void put(int key, Object *value)
    {
        entries.insert(pair<int, Object *>(key, value));
    }
    Object *get(int key)
    {
        return entries.at(key);
    }
};

MapCache *MapCache::INSTANCE = nullptr;

// directory

class Employee : public Object
{
private:
    int id;
    string name;
    long phone;

public:
    Employee(string n, long p)
    {
        name = n;
        phone = p;
    }
    void setId(int value)
    {
        id = value;
    }

    int getId()
    {
        return id;
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

class InvalidEmployeeException : public DirectoryException
{
public:
    InvalidEmployeeException(string msg) : DirectoryException(msg)
    {
    }
};

class EmployeeNotFoundException : public DirectoryException
{
public:
    EmployeeNotFoundException(string msg) : DirectoryException(msg)
    {
    }
};

class Directory : public Object
{
public:
    virtual int add(Employee *e) = 0;
    virtual Employee *find(int id) = 0;
};

class InMemoryDirectory : public Directory
{
private:
    Cache *cache;
    int id;

public:
    InMemoryDirectory(Cache *cache)
    {
        this->cache = cache;
        id = 1;
    }
    int add(Employee *e)
    {
        e->setId(id++);
        cache->put(e->getId(), e);
        return e->getId();
    }
    Employee *find(int id)
    {
        return (Employee *)cache->get(id);
    }
};

class LoggingProxy : public Directory
{
private:
    Directory *target;

public:
    LoggingProxy(Directory *target)
    {
        this->target = target;
    }
    int add(Employee *e)
    {
        try
        {
            cout << "Logger: Entering add: " << e->getName() << endl;
            int value = target->add(e);
            cout << "Logger: Exiting add: " << value << endl;
            return value;
        }
        catch (DirectoryException *e)
        {
            cout << "Logger: Handling add" << endl;
            throw e;
        }
    }

    Employee *find(int id)
    {
        try
        {
            cout << "Logger: Entering find: " << id << endl;
            Employee *e = (Employee *)target->find(id);
            cout << "Logger: Exiting find: " << e->getName() << endl;
            return e;
        }
        catch (DirectoryException *e)
        {
            cout << "Logger: Handling find" << endl;
            throw e;
        }
    }
};

class ValidationProxy : public Directory
{
private:
    Directory *target;

public:
    ValidationProxy(Directory *target)
    {
        this->target = target;
    }
    int add(Employee *e)
    {
        if (e->getName() == "" || e->getPhone() < 0)
        {
            throw new InvalidEmployeeException("Invalid Employee");
        }
        return target->add(e);
    }

    Employee *find(int id)
    {
        return (Employee *)target->find(id);
    }
};

class AsyncDirectory : public Directory
{
private:
    Directory *target;
    Broker *broker;

public:
    AsyncDirectory(Directory *target, Broker *broker)
    {
        this->target = target;
        this->broker = broker;
    }

    int add(Employee *e)
    {
        int id = target->add(e);
        broker->publish(new Message("/directory/employee/add", e->getName()));
        return id;
    }

    Employee *find(int id)
    {
        Employee *e = (Employee *)target->find(id);
        broker->publish(new Message("/directory/employee/find", e->getName()));
        return e;
    }
};

// app

class AbstractHandler : public Handler
{
private:
    string id;
    string topic;

public:
    AbstractHandler(string id, string topic)
    {
        this->id = id;
        this->topic = topic;
    }

    string getId()
    {
        return id;
    }

    string getTopic()
    {
        return topic;
    }
};

class AuditHandler : public AbstractHandler
{
private:
    Auditor *auditor;

public:
    AuditHandler(string id, string topic, Auditor *auditor) : AbstractHandler(id, topic)
    {
        this->auditor = auditor;
    }

    void handle(Message *message)
    {
        auditor->log(message->getBody());
    }
};

class EmailHandler : public AbstractHandler
{
private:
    Notifier *notifier;

public:
    EmailHandler(string id, string topic, Notifier *notifier) : AbstractHandler(id, topic)
    {
        this->notifier = notifier;
    }
    void handle(Message *message)
    {
        notifier->notify(message->getBody());
    }
};

class ObjectFactory
{
public:
    static Object *get(string key)
    {
        if (key == "auditor")
        {
            return new SimpleAuditor();
        }

        if (key == "notifier")
        {
            return new EmailNotifier();
        }

        if (key == "directory")
        {
            Cache *cache = (Cache *)get("cache");
            return new InMemoryDirectory(cache);
        }

        if (key == "cache")
        {
            return MapCache::getInstance();
        }

        if (key == "broker")
        {
            return MessageBroker::getInstance();
        }

        if (key == "logger-directory")
        {
            Directory *target = (Directory *)get("directory");
            return new LoggingProxy(target);
        }

        if (key == "validator-directory")
        {
            Directory *target = (Directory *)get("directory");
            return new ValidationProxy(target);
        }

        if (key == "logger-validator-directory")
        {
            Directory *target = (Directory *)get("directory");
            target = new ValidationProxy(target);
            target = new LoggingProxy(target);
            return target;
        }

        if (key == "validator-logger-directory")
        {
            Directory *target = (Directory *)get("directory");
            target = new LoggingProxy(target);
            target = new ValidationProxy(target);
            return target;
        }

        if (key == "full-system")
        {
            Directory *target = (Directory *)get("directory");
            Broker *broker = (Broker *)get("broker");
            target = new AsyncDirectory(target, broker);
            target = new LoggingProxy(target);
            target = new ValidationProxy(target);
            return target;
        }

        throw new DirectoryException("Object not available");
    }
};

int main()
{
    try
    {
        Directory *dir = (Directory *)ObjectFactory::get("full-system");
        Broker *broker = (Broker *)ObjectFactory::get("broker");
        Auditor *auditor = (Auditor *)ObjectFactory::get("auditor");
        Notifier *notifier = (Notifier *)ObjectFactory::get("notifier");

        broker->subscribe(new EmailHandler("com.glarimy.notifier.add", "/directory/employee/add", notifier));
        broker->subscribe(new AuditHandler("com.glarimy.auditor.add", "/directory/employee/add", auditor));
        broker->subscribe(new AuditHandler("com.glarimy.auditor.find", "/directory/employee/find", auditor));

        int id1 = dir->add(new Employee("Krishna", 1234));
        dir->find(id1);

        int id2 = dir->add(new Employee("Koyya", -2345));
        dir->find(id2);
    }
    catch (DirectoryException *d)
    {
        cout << d->getMessage() << endl;
    }
    return 0;
}