#include <iostream>

using namespace std;

class Component
{
private:
    Component() {}
    string color;
    string title;
    string picture;

public:
    void service()
    {
        cout << color << " " << title << " " << picture << endl;
    }
    class ComponentBuilder;
};

class Component::ComponentBuilder
{
private:
    string color;
    string title;
    string picture;

public:
    ComponentBuilder() {}
    ComponentBuilder *setColor(string option)
    {
        color = option;
        return this;
    }
    ComponentBuilder *setTitle(string option)
    {
        title = option;
        return this;
    }
    ComponentBuilder *setPicture(string option)
    {
        picture = option;
        return this;
    }
    Component *build()
    {
        Component *component = new Component();
        component->color = color;
        component->picture = picture;
        component->title = title;
        return component;
    }
};

int main()
{
    Component *component = Component::ComponentBuilder()
        .setColor("yellow")
        ->setPicture("landscape")
        ->setTitle("frame")
        ->build();
    component->service();
    return 0;
}