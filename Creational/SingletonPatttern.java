/*
The Singleton Pattern is a creational design pattern that ensures:
Only one instance of a class exists.
There is a global access point to that instance.
*/

class Database {

    private static volatile Database instance;

    private Database() {}

    public static Database getInstance() {

        if (instance == null) {

            synchronized (Database.class) {

                if (instance == null) {
                    instance = new Database();
                }
            }
        }

        return instance;
    }
}

public class SingletonPatttern {
    public static void main(String[] args) {

        Database d1 = Database.getInstance();

        Database d2 = Database.getInstance();

        Database d3 = Database.getInstance();

        System.out.println(d1 == d2);
        System.out.println(d2 == d3);
    }    
}
