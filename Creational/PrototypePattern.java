/*
The Prototype Pattern creates new objects by copying (cloning) an existing object instead of creating one from scratch.
*/

interface Prototype {
    Prototype clone();
}

class Employee implements Prototype {

    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public Employee clone() {
        return new Employee(name, department);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " " + department;
    }
}

public class PrototypePattern {
     public static void main(String[] args) {

        Employee e1 = new Employee("Rohan", "Backend");

        Employee e2 = e1.clone();

        e2.setName("Sahil");

        System.out.println(e1);

        System.out.println(e2);
    }
}
