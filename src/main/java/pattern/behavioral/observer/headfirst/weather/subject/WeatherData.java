package pattern.behavioral.observer.headfirst.weather.subject;

import pattern.behavioral.observer.headfirst.weather.observer.WeatherObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements WeatherSubject {

    private final List<WeatherObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(WeatherObserver weatherObserver) {
        this.observers.add(weatherObserver);
    }

    @Override
    public void removeObserver(WeatherObserver weatherObserver) {
        this.observers.remove(weatherObserver);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(WeatherObserver::update);
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
