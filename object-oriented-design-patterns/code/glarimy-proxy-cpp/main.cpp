#include <iostream>
using namespace std;

class Component 
{
public:
    virtual void service() = 0;
};

class ConcreteComponent: public Component
{
public:
    void service()
    {
        cout << "ConcreteComponent::service()" << endl;
    }
};

class Proxy : public Component
{
    private:
        Component* target;
public:
    Proxy(Component* target)
    {
        this->target = target;
    }
    void service()
    {
        cout << "Proxy: pre-processing" << endl;
        this->target->service();
        cout << "Proxy: post-processing" << endl;
    }
};

class Factory
{
public:
    static Component* get(string key)
    {
        if (key == "component")
        {
            return new Proxy(new ConcreteComponent());
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