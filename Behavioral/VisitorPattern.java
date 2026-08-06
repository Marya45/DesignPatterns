/*
The Visitor Pattern lets you add new operations to a group of existing objects without modifying their classes.
Instead of putting every operation inside the object itself, you move the operation into a separate Visitor class.


Imagine a hospital.

Patients:
Child
Adult
Senior Citizen

Different professionals visit them:
Doctor
Nurse
Insurance Agent

Today a Doctor visits everyone.

Tomorrow a Nurse visits everyone.

Next week an Insurance Agent visits everyone.

Notice:

Patients don't change.
Visitors change.

This is exactly the Visitor Pattern.

*/


interface Visitor {

    void visit(Circle circle);

    void visit(Rectangle rectangle);
}

interface Shape {

    void accept(Visitor visitor);
}

class Circle implements Shape {

    @Override
    public void accept(Visitor visitor) {

        visitor.visit(this);
    }
}

class Rectangle implements Shape {

    @Override
    public void accept(Visitor visitor) {

        visitor.visit(this);
    }
}

class DrawVisitor implements Visitor {

    @Override
    public void visit(Circle circle) {

        System.out.println("Drawing Circle");
    }

    @Override
    public void visit(Rectangle rectangle) {

        System.out.println("Drawing Rectangle");
    }
}

class AreaVisitor implements Visitor {

    @Override
    public void visit(Circle circle) {

        System.out.println("Area of Circle");
    }

    @Override
    public void visit(Rectangle rectangle) {

        System.out.println("Area of Rectangle");
    }
}

public class VisitorPattern {
     public static void main(String[] args) {

        Shape circle = new Circle();

        Shape rectangle = new Rectangle();

        Visitor draw = new DrawVisitor();

        Visitor area = new AreaVisitor();

        circle.accept(draw);

        rectangle.accept(draw);

        circle.accept(area);

        rectangle.accept(area);
    }
}
