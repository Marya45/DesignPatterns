/*
The Command Pattern is a behavioral design pattern that encapsulates a request as an object.
Instead of calling a method directly, you create a Command object that contains all the information needed to perform the action.

In simple words:

Turn a method call into an object.

This allows you to:

Queue commands
Undo/redo operations
Log commands
Schedule commands
Execute commands later

*/

interface Command {
    void execute();
}

class TV {

    public void turnOn() {
        System.out.println("TV ON");
    }

    public void turnOff() {
        System.out.println("TV OFF");
    }
}


class TurnOnCommand implements Command {

    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}

class TurnOffCommand implements Command {

    private TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}

class Remote {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandPattern {
    public static void main(String[] args) {

        TV tv = new TV();

        Command on = new TurnOnCommand(tv);

        Command off = new TurnOffCommand(tv);

        Remote remote = new Remote();

        remote.setCommand(on);

        remote.pressButton();

        remote.setCommand(off);

        remote.pressButton();
    }
}
