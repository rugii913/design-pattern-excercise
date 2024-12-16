package pattern.behavioral.observer.guru.listeners;

import java.io.File;

// common observer interface
public interface EventListener {

    void update(String eventType, File file);
}
