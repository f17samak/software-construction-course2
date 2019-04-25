package lec10observer.weatherorama.ver1;

import lec10observer.weatherorama.ver1.PollutionData;
import lec10observer.weatherorama.ver1.WeatherData;

import javax.swing.*;
import java.awt.*;

public class CurrentConditionDisplay implements Observer {

    private JFrame frame;
    private JTextArea weatherArea, pollutionArea;

    public CurrentConditionDisplay() {

        frame = new JFrame();
        frame.setSize(200, 400);
        frame.setTitle("Current Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        weatherArea = new JTextArea(200, 200);
        weatherArea.setBackground(Color.PINK);
        weatherArea.setText("Current Weather:\n\n");

        pollutionArea = new JTextArea(200, 200);
        pollutionArea.setBackground(Color.CYAN);
        pollutionArea.setText("Current pollution:\n\n");

        frame.setLayout(new GridLayout(2, 1));
        frame.add(weatherArea);
        frame.add(pollutionArea);
    }

    @Override
    public void update(Subject2 data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;
            weatherArea.setBackground(Color.PINK);
            weatherArea.setText("Current Weather:\n\n");
            weatherArea.append("Temperature = " + weatherData.getTemperature() + "\n");
            weatherArea.append("Humidity = " + weatherData.getHumidity() + "\n");
            weatherArea.append("Pressure = " + weatherData.getPressure() + "\n");
        }
        if (data instanceof PollutionData) {
            PollutionData pollutionData = (PollutionData) data;
            pollutionArea.setBackground(Color.CYAN);
            pollutionArea.setText("Current pollution:\n\n");
            pollutionArea.append("Pollution measurement10 = " + pollutionData.getPm10() + "\n");
            pollutionArea.append("Pollution measurement2_5 = " + pollutionData.getPm2_5() + "\n");
        }
    }
}
