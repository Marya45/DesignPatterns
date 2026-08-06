/*
The Builder Pattern lets you construct complex objects step by step, especially when an object has many optional fields.
Instead of having a constructor with many parameters, you use a Builder to gradually configure the object and then call build().

Imagine ordering a burger.

You choose:

Bun
Cheese
Patty
Sauce
Lettuce
Onion
Instead of one huge constructor
You build it step by step

*/

class User {

    private String name;
    private String email;
    private String company;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.company = builder.company;
    }

    @Override
    public String toString() {
        return name + " " + email + " " + " " + company;
    }
    
    public static class Builder {

        private String name;
        private String email;
        private String company;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}

public class BuilderPattern {
    public static void main(String[] args) {

        User user = new User.Builder()
                .name("Rohan")
                .email("rohan.marya15@gmail.com")
                .company("Google")
                .build();

        System.out.println(user);
    }
}
