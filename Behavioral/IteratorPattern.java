/*
Iterator allows you to traverse a collection without knowing how the collection is implemented.

*/

// iterator interface
interface Iterator {

    boolean hasNext();

    Object next();
}

// collection
class StudentCollection {

    private String[] students = {
        "Rohan",
        "Rahul",
        "Amit"
    };

    public Iterator createIterator() {
        return new StudentIterator(students);
    }
}

class StudentIterator implements Iterator {

    private String[] students;

    private int index = 0;

    public StudentIterator(String[] students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {
        return index < students.length;
    }

    @Override
    public Object next() {

        if(hasNext())
            return students[index++];

        return null;
    }
}

public class IteratorPattern {
    public static void main(String[] args) {

        StudentCollection collection = new StudentCollection();

        Iterator iterator = collection.createIterator();

        while(iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }
}
