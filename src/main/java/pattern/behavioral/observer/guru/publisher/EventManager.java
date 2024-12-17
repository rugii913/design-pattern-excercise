package pattern.behavioral.observer.guru.publisher;

import pattern.behavioral.observer.guru.listeners.EventListener;

import java.io.File;
import java.util.*;

public class EventManager {

    Map<String, List<EventListener>> eventListenerListMap = new HashMap<>();

    public EventManager(String... eventTypes) {
        Arrays.stream(eventTypes).forEach(eventType -> this.eventListenerListMap.put(eventType, new ArrayList<>()));
    }

    public void subscribe(String eventType, EventListener listener) {
        eventListenerListMap.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        eventListenerListMap.get(eventType).remove(listener);
    }

    public void notify(String eventType, File file) {
        eventListenerListMap.get(eventType).forEach(listener -> listener.update(eventType, file));
    }
}
