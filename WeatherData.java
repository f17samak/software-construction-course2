package lec10observer.weatherorama.ver1;

import java.util.ArrayList;
import java.util.List;

public class WeatherData extends Subject2 {

    private double temperature;
    private double humidity;
    private double pressure;

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setMeasurement(double temp, double humid, double prs) {
        temperature = temp;
        humidity = humid;
        pressure = prs;
        notifyObservers();
    }
}
