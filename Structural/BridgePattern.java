/*
Bridge Pattern separates an abstraction from its implementation so that both can evolve independently.
Avoiding an explosion of subclasses when you have multiple independent dimensions of variation.

Imagine a Remote Control and a TV.

There are different remotes:
Basic Remote
Smart Remote
There are different TV brands:
Sony
Samsung
LG

Without the Bridge Pattern, you'd need classes like:
BasicSonyRemote
BasicSamsungRemote
BasicLGRemote

SmartSonyRemote
SmartSamsungRemote
SmartLGRemote

As more remotes or TV brands are added, the number of classes grows rapidly.

With the Bridge Pattern:

Remote -----> TV

Any remote can work with any TV.
*/


interface Device {
    void on();
    void off();
}

// concrete implementation
class TV implements Device {

    @Override
    public void on() {
        System.out.println("TV ON");
    }

    @Override
    public void off() {
        System.out.println("TV OFF");
    }
}

class Radio implements Device {

    @Override
    public void on() {
        System.out.println("Radio ON");
    }

    @Override
    public void off() {
        System.out.println("Radio OFF");
    }
}

// abstraction
abstract class Remote {

    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    abstract void power();
}

// refined abstraction
class BasicRemote extends Remote {

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    void power() {
        device.on();
    }
}

class SmartRemote extends Remote {

    public SmartRemote(Device device) {
        super(device);
    }

    @Override
    void power() {
        device.on();
        System.out.println("Voice control enabled");
    }
}

public class BridgePattern {
    public static void main(String[] args) {

        Device tv = new TV();
        Device radio = new Radio();

        Remote remote1 = new BasicRemote(tv);
        remote1.power();

        Remote remote2 = new SmartRemote(radio);
        remote2.power();
    }

}

/*
Output:
TV ON
Radio ON
Voice control enabled
*/