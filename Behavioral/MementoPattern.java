/*
The Memento Pattern allows you to save and restore an object's previous state without exposing its internal details.
The most common use case is Undo/Redo.
*/
import java.util.Stack;

class EditorMemento {

    private final String text;

    public EditorMemento(String text) {

        this.text = text;
    }

    public String getText() {

        return text;
    }
}

class Editor {

    private String text;

    public void setText(String text) {

        this.text = text;
    }

    public String getText() {

        return text;
    }

    public EditorMemento save() {

        return new EditorMemento(text);
    }

    public void restore(EditorMemento memento) {

        text = memento.getText();
    }
}


class History {

    private Stack<EditorMemento> history = new Stack<>();

    public void save(EditorMemento memento) {
        history.push(memento);
    }

    public EditorMemento undo() {
        return history.pop();
    }
}

public class MementoPattern {
    public static void main(String[] args) {

        Editor editor = new Editor();

        History history = new History();

        editor.setText("Hello");

        history.save(editor.save());

        editor.setText("Hello World");

        System.out.println(editor.getText());

        editor.restore(history.undo());

        System.out.println(editor.getText());
    }
}
