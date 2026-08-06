/*
The Template Method Pattern defines the skeleton (template) of an algorithm in a base class while allowing subclasses to override specific steps without changing the overall algorithm.
*/

abstract class Beverage {

    // Template Method
    public final void prepareDrink() {

        boilWater();

        addIngredient();

        pour();

        addExtra();
    }

    private void boilWater() {
        System.out.println("Boiling Water");
    }

    private void pour() {
        System.out.println("Pouring into Cup");
    }

    protected abstract void addIngredient();

    protected abstract void addExtra();
}

class Tea extends Beverage {

    @Override
    protected void addIngredient() {

        System.out.println("Adding Tea Leaves");
    }

    @Override
    protected void addExtra() {

        System.out.println("Adding Sugar");
    }
}

class Coffee extends Beverage {

    @Override
    protected void addIngredient() {

        System.out.println("Adding Coffee");
    }

    @Override
    protected void addExtra() {

        System.out.println("Adding Milk");
    }
}

public class TemplatePattern {
    public static void main(String[] args) {

        Beverage tea = new Tea();
        tea.prepareDrink();

        Beverage coffee = new Coffee();
        coffee.prepareDrink();
    }
}
