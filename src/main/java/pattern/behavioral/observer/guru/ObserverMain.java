package pattern.behavioral.observer.guru;

import pattern.behavioral.observer.guru.editor.Editor;
import pattern.behavioral.observer.guru.listeners.EmailNotificationListener;
import pattern.behavioral.observer.guru.listeners.LogOpenListener;

public class ObserverMain {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/some/path/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("example@aaa.aaa"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
