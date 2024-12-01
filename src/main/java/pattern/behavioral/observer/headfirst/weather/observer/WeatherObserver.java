package pattern.behavioral.observer.headfirst.weather.observer;

public interface WeatherObserver {

    void update(float temperature, float humidity, float pressure);
}
