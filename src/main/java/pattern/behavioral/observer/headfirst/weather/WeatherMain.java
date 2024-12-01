package pattern.behavioral.observer.headfirst.weather;

import pattern.behavioral.observer.headfirst.weather.observer.CurrentConditionDisplay;
import pattern.behavioral.observer.headfirst.weather.observer.ForecastDisplay;
import pattern.behavioral.observer.headfirst.weather.observer.HeatIndexDisplay;
import pattern.behavioral.observer.headfirst.weather.observer.StatisticsDisplay;
import pattern.behavioral.observer.headfirst.weather.subject.WeatherData;

public class WeatherMain {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        new CurrentConditionDisplay(weatherData);
        new StatisticsDisplay(weatherData);
        new ForecastDisplay(weatherData);
        new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
