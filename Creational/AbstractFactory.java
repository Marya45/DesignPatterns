/*
The Abstract Factory Pattern provides an interface for creating families of related objects without specifying their concrete classes.

                   Client
                      |
               GUIFactory
               /         \
      WindowsFactory   MacFactory
          |    |          |    |
     WinBtn WinChk    MacBtn MacChk
*/

// product interface
interface Button {
    void paint();
}

interface Checkbox {
    void check();
}

// concrete products
class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {

    @Override
    public void check() {
        System.out.println("Windows Checkbox");
    }
}

class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Mac Button");
    }
}

class MacCheckbox implements Checkbox {

    @Override
    public void check() {
        System.out.println("Mac Checkbox");
    }
}

// abstract factory
interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {

        GUIFactory factory = new WindowsFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.check();
    }

}
