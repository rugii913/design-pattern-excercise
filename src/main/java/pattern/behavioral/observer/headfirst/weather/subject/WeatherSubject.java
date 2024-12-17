package pattern.behavioral.observer.headfirst.weather.subject;

import pattern.behavioral.observer.headfirst.weather.observer.WeatherObserver;

public interface WeatherSubject {

    void registerObserver(WeatherObserver weatherObserver);

    void removeObserver(WeatherObserver weatherObserver);

    void notifyObservers();
}
