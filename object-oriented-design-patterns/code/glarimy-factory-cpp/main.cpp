#include <iostream>

using namespace std;

class Object
{
};

class Component : public Object
{
public:
    virtual void service() = 0;
};

class ConcreteComponent : public Component
{
public:
    ConcreteComponent() {}

    void service()
    {
        cout << "ConcreteComponent::service" << endl;
    }
};

class Factory
{
public:
    static Object *get(string key)
    {
        if (key == "component")
        {
            return new ConcreteComponent();
        }
        throw "Object not available";
    }
};

int main()
{
    try
    {
        Component *component = (Component *)Factory::get("component");
        component->service();
    }
    catch (char const *m)
    {
        cout << m << endl;
    }
    return 0;
}