package pattern.behavioral.observer.headfirst.weather.observer;

import pattern.behavioral.observer.headfirst.weather.subject.WeatherData;

public class StatisticsDisplay implements WeatherObserver, DisplayElement {

    private float maxTemperature = Float.MIN_VALUE;
    private float minTemperature = Float.MAX_VALUE;
    private float temperatureSum = 0f;
    private int numberReadings;
    private final WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        float currentTemperature = this.weatherData.getTemperature();

        temperatureSum += currentTemperature;
        numberReadings++;

        if (currentTemperature > maxTemperature) {
            maxTemperature = currentTemperature;
        }

        if (currentTemperature < minTemperature) {
            minTemperature = currentTemperature;
        }

        display();
    }

    @Override
    public void display() {
        System.out.printf(
                "Avg/Max/Min temperature = %.1f / %.1f / %.1f%n",
                this.temperatureSum / this.numberReadings,
                this.maxTemperature,
                this.minTemperature
        );
    }
}
