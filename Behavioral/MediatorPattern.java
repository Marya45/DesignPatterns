/*
The Mediator Pattern is a behavioral design pattern that centralizes communication between multiple objects.
Instead of objects talking to each other directly, they communicate through a Mediator.

In simple words:
Objects don't know about each other—they only know the Mediator.
This reduces coupling between objects.
*/

import java.util.*;

// mediator interface
interface ChatMediator {

    void sendMessage(String message, User sender);

    void addUser(User user);
}


class ChatRoom implements ChatMediator {

    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {

        for(User user : users) {

            if(user != sender) {

                user.receive(message);
            }
        }
    }
}

class User {

    private String name;

    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {

        this.name = name;

        this.mediator = mediator;
    }

    public void send(String message) {

        System.out.println(name + " sends: " + message);

        mediator.sendMessage(message, this);
    }

    public void receive(String message) {

        System.out.println(name + " received: " + message);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {

        ChatMediator room = new ChatRoom();

        User alice = new User("Alice", room);

        User bob = new User("Bob", room);

        User charlie = new User("Charlie", room);

        room.addUser(alice);
        room.addUser(bob);
        room.addUser(charlie);

        alice.send("Hello Everyone!");
    }
}
