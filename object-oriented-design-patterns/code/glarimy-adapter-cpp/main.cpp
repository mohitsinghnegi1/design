#include <iostream>
using namespace std;

class Adapter 
{
public:
    virtual void adapt() = 0;
};

class Component
{
public:
    void service()
    {
        cout << "Component::service()" << endl;
    }
};

class ComponentAdapter : public Adapter
{
    private:
        Component* target;
public:
    ComponentAdapter()
    {
        target = new Component();
    }
    void adapt()
    {
        this->target->service();
    }
};

class Factory
{
public:
    static Adapter* get(string key)
    {
        if (key == "adapter")
        {
            return new ComponentAdapter();
        }

        throw "Object not available";
    }
};

int main()
{
    try
    {
        Adapter* adapter = Factory::get("adapter");
        adapter->adapt();
    }
    catch (const char* e)
    {
        cout << e << endl;
    }
    return 0;
}