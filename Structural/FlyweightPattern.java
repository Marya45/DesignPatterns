/*
The Flyweight Pattern reduces memory usage by sharing common objects instead of creating duplicate ones.
If many objects have the same state, store that shared state only once and reuse it.

Imagine a text editor displaying:

AAAAAAAAAA

There are 10 A's.

Without Flyweight:
A1
A2
A3
...
A10

10 separate objects.

With Flyweight:
      Character('A')
           ^
     ______|______
    /   /  |   \   \
Pos1 Pos2 Pos3 ... Pos10

There is one shared Character('A') object, while each position stores only information like its row and column.


Intrinsic State (Shared) Stored inside the Flyweight object.
*/

import java.util.*;

// flyweight interface
interface Shape {
    void draw(int x, int y);
}

class Circle implements Shape {

    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println(
            "Drawing " + color + " circle at (" + x + "," + y + ")"
        );
    }
}

// flyweight factory
class ShapeFactory {

    private static Map<String, Circle> circles = new HashMap<>();

    public static Circle getCircle(String color) {

        if(!circles.containsKey(color)) {
            circles.put(color, new Circle(color));
        }

        return circles.get(color);
    }
}

public class FlyweightPattern {
    public static void main(String[] args) {

        Shape c1 = ShapeFactory.getCircle("Red");
        c1.draw(10,20);

        Shape c2 = ShapeFactory.getCircle("Red");
        c2.draw(40,50);

        Shape c3 = ShapeFactory.getCircle("Blue");
        c3.draw(60,70);
    }
}

/*
Output:
Drawing Red circle at (10,20)
Drawing Red circle at (40,50)
Drawing Blue circle at (60,70)

*/