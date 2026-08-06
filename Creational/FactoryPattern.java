/*
The Factory Pattern provides an interface for creating objects without exposing the object creation logic to the client.
*/

// product interface
interface Notification {
    void send();
}

// concrete products
class EmailNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending Email");
    }
}

class SmsNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending SMS");
    }
}

class PushNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Sending Push Notification");
    }
}


class NotificationFactory {

    public static Notification getNotification(String type) {

        if(type.equalsIgnoreCase("EMAIL"))
            return new EmailNotification();

        if(type.equalsIgnoreCase("SMS"))
            return new SmsNotification();

        if(type.equalsIgnoreCase("PUSH"))
            return new PushNotification();

        throw new IllegalArgumentException("Invalid Type");
    }
}


public class FactoryPattern {
     public static void main(String[] args) {

        Notification notification = NotificationFactory.getNotification("EMAIL");

        notification.send();
    }
}
