/* 
The Adapter pattern is used to convert one interface to another that a client expects. It allows incompatible interfaces to work together.
You have a class that performs certain operations (e.g., MediaPlayer), but it doesn’t support the format required by the client (e.g., VLC file format). The adapter helps by converting the old format into the new one.
*/

// Suppose your application expects all payment gateways to have a pay() method.

// target interface
interface PaymentGateway {
    void pay(int amount);
}

// existing class
// adaptee class
class RazorpayAPI {
    public void makePayment(int rupees) {
        System.out.println("Paid " + rupees + " using Razorpay");
    }
}

// adapter
class RazorpayAdapter implements PaymentGateway {

    private RazorpayAPI razorpay;

    public RazorpayAdapter(RazorpayAPI razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public void pay(int amount) {
        razorpay.makePayment(amount);
    }
}

public class AdapterPattern {

    public static void main(String[] args) {

        PaymentGateway gateway = new RazorpayAdapter(new RazorpayAPI());

        gateway.pay(1000);
    }
}

/*
Output: 
Paid 1000 using Razorpay
*/