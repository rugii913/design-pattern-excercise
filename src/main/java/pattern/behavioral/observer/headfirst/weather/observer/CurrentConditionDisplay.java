package pattern.behavioral.observer.headfirst.weather.observer;

import pattern.behavioral.observer.headfirst.weather.subject.WeatherData;

public class CurrentConditionDisplay implements WeatherObserver, DisplayElement {

    private float temperature;
    private float humidity;
    private final WeatherData weatherData; // WeatherSubject의 subtype

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.temperature = this.weatherData.getTemperature();
        this.humidity = this.weatherData.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.printf("Current conditions: %.1fF degrees, %.1f%% humidity %n", this.temperature, this.humidity);
    }
}
