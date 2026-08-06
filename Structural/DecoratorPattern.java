/*
The Decorator Pattern lets you add new behavior to an object dynamically without modifying its class.
Instead of creating many subclasses, you wrap the original object with one or more decorator objects.

Imagine ordering a coffee.

Base coffee:
Coffee

You can add:
Milk
Sugar
Whipped Cream
Chocolate

Instead of creating classes like:

MilkCoffee
SugarCoffee
MilkSugarCoffee
MilkSugarChocolateCoffee
...

you wrap the coffee with decorators.

Each decorator adds its own behavior.

*/


interface Coffee {
    String getDescription();
    double getCost();
}

// concrete component
class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 100;
    }
}

// base decorator
abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// concrete decorators

class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 20;
    }
}

class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 10;
    }
}


public class DecoratorPattern{
    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
    }

}

/*
Output:
Simple Coffee, Milk, Sugar
130.0
*/