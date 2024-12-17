package pattern.behavioral.observer.headfirst.weather.observer;

import pattern.behavioral.observer.headfirst.weather.subject.WeatherData;

public class ForecastDisplay implements WeatherObserver, DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;
    private final WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update() {
        this.lastPressure = this.currentPressure;
        this.currentPressure = this.weatherData.getPressure();

        display();
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather.");
        }
    }
}
