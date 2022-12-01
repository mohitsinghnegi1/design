#include <iostream>

using namespace std;

class Component
{
private:
    static Component *INSTANCE;
    Component()
    {
        cout << "Instantiated" << endl;
    };

public:
    static Component *getInstance()
    {
        if (INSTANCE == nullptr)
            INSTANCE = new Component();
        return INSTANCE;
    }

    void service()
    {
        cout << "ConcreteComponent::service" << endl;
    }
};

Component *Component::INSTANCE = nullptr;

int main()
{
    Component *component = Component::getInstance();
    component->service();
    return 0;
}