package pattern.behavioral.observer.guru.listeners;

import java.io.File;

public class FileOpenLogger implements EventListener {

    private final File logFile;

    public FileOpenLogger(String fileName) {
        this.logFile = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.printf("Save to log %s: Someone has performed %s operation with the following file: %s%n", this.logFile, eventType, file.getName());
    }
}
