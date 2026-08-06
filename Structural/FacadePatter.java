/*
The Facade Pattern provides a simple, unified interface to a complex subsystem.
Instead of the client interacting with many classes, it interacts with one Facade class, which coordinates everything behind the scenes.

Think of ordering food at a restaurant.

Without a waiter (Facade), you'd have to interact with:

Chef
Cashier
Kitchen staff
Beverage counter
Billing

With a waiter: The customer only talks to the waiter.

*/

class Projector {

    void on() {
        System.out.println("Projector ON");
    }
}

class SoundSystem {

    void on() {
        System.out.println("Sound ON");
    }

    void setVolume(int volume) {
        System.out.println("Volume: " + volume);
    }
}

class DVDPlayer {

    void on() {
        System.out.println("DVD ON");
    }

    void play(String movie) {
        System.out.println("Playing " + movie);
    }
}

// facade class
class HomeTheaterFacade {

    private Projector projector = new Projector();
    private SoundSystem sound = new SoundSystem();
    private DVDPlayer dvd = new DVDPlayer();

    public void watchMovie(String movie) {

        projector.on();

        sound.on();
        sound.setVolume(10);

        dvd.on();
        dvd.play(movie);
    }
}


public class FacadePatter {
    public static void main(String[] args) {

        HomeTheaterFacade theater = new HomeTheaterFacade();

        theater.watchMovie("Avengers");
    }
}


/*
Output:
Projector ON
Sound ON
Volume: 10
DVD ON
Playing Avengers
*/