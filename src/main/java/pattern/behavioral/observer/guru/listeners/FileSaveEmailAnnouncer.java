package pattern.behavioral.observer.guru.listeners;

import java.io.File;

public class FileSaveEmailAnnouncer implements EventListener{

    private final String email;

    public FileSaveEmailAnnouncer(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.printf("Email to %s: Someone has performed %s operation with the following file: %s%n", this.email, eventType, file.getName());
    }
}
