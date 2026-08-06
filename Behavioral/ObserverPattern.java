/*
The Observer Pattern defines a one-to-many dependency between objects.
When one object (Subject) changes its state, all dependent objects (Observers) are automatically notified and updated.
*/
import java.util.*;

interface Observer {
    void update(String message);
}

class EmailObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("SMS: " + message);
    }
}

class InvoiceObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Invoice Generated: " + message);
    }
}

// subject
class OrderService {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {

        for(Observer observer : observers) {
            observer.update(message);
        }
    }

    public void placeOrder() {

        System.out.println("Order Placed");

        notifyObservers("Order #101");
    }
}

public class ObserverPattern {
    public static void main(String[] args) {

        OrderService order = new OrderService();

        order.addObserver(new EmailObserver());
        order.addObserver(new SmsObserver());
        order.addObserver(new InvoiceObserver());

        order.placeOrder();
    }

}
