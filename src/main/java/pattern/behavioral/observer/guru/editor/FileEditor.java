package pattern.behavioral.observer.guru.editor;

import pattern.behavioral.observer.guru.publisher.EventManager;

import java.io.File;

public class FileEditor {

    private final EventManager eventManager;
    private File file;

    public FileEditor(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        eventManager.notify("open", file);
    }

    public void saveFile() {
        if (this.file != null) {
            eventManager.notify("save", file);
        } else {
            throw new RuntimeException("Please open a file first.");
        }
    }
}
