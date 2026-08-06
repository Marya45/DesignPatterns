/*
The Composite Pattern is a structural design pattern that lets you treat individual objects and groups of objects uniformly.
The key idea is that both a single object (Leaf) and a collection of objects (Composite) implement the same interface, so the client doesn't need to know whether it's dealing with one object or many.

Think of your computer's file system.
File → Leaf
Folder → Composite
Both can be treated as a FileSystemItem.

You can perform operations like:
item.show();

without caring whether item is a file or a folder.
*/

// component

import java.util.*;

interface FileSystemItem {
    void show();
}

// leaf
class File implements FileSystemItem {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}

// composite
class Folder implements FileSystemItem {

    private String name;
    private List<FileSystemItem> items = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        items.add(item);
    }

    public void remove(FileSystemItem item) {
        items.remove(item);
    }

    @Override
    public void show() {

        System.out.println(name);

        for(FileSystemItem item : items) {
            item.show();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {

        File resume = new File("Resume.pdf");
        File notes = new File("Notes.txt");

        Folder documents = new Folder("Documents");

        documents.add(resume);
        documents.add(notes);

        File photo = new File("Photo.jpg");

        Folder pictures = new Folder("Pictures");
        pictures.add(photo);

        Folder root = new Folder("Root");

        root.add(documents);
        root.add(pictures);

        root.show();
    }
}

/*
Output:

Root
Documents
Resume.pdf
Notes.txt
Pictures
Photo.jpg

*/