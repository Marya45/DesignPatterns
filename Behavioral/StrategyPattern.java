/*
The Strategy Pattern lets you define a family of algorithms, encapsulate each one in a separate class, and make them interchangeable at runtime.

Instead of using lots of if-else or switch statements, you create different strategy classes and choose one dynamically.
*/

interface PaymentStrategy {
    void pay(double amount);
}

class CardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

class UpiPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class PaymentService {

    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        strategy.pay(amount);
    }
}


public class StrategyPattern {
    public static void main(String[] args) {

        PaymentStrategy strategy = new UpiPayment();

        PaymentService service = new PaymentService(strategy);

        service.processPayment(500);
    }
}
