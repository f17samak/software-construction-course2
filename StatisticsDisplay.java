package lec10observer.weatherorama.ver1;

import lec10observer.weatherorama.ver1.WeatherData;
import lec10observer.weatherorama.ver1.PollutionData;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

    private double prevTemp;
    private double pollutionMeasurement;

    private JFrame frame;
    private JTextArea weatherArea, pollutionArea;

    public StatisticsDisplay() {

        frame = new JFrame();
        frame.setSize(200, 400);
        frame.setTitle("Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        weatherArea = new JTextArea(200, 200);
        weatherArea.setBackground(Color.ORANGE);
        weatherArea.setText("Average Current Weather:\n\n");

        pollutionArea = new JTextArea(200, 200);
        pollutionArea.setBackground(Color.BLUE);
        pollutionArea.setText("Average Current Pollution:\n\n");

        frame.setLayout(new GridLayout(2, 1));
        frame.add(weatherArea);
        frame.add(pollutionArea);

    }

    @Override
    public void update(Subject2 data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;
            weatherArea.setBackground(Color.ORANGE);
            weatherArea.setText("Average Current Weather:\n\n");
            if (prevTemp == 0)
                prevTemp = weatherData.getTemperature();
            double avg = (prevTemp + weatherData.getTemperature()) / 2;
            weatherArea.append("Temperature = " + avg + "\n");
            prevTemp = avg;
        }


        if (data instanceof PollutionData) {
            PollutionData pollutionData = (PollutionData) data;
            pollutionArea.setBackground(Color.BLUE);
            pollutionArea.setText("Average Current Pollution:\n\n");
            if (pollutionMeasurement == 0)
                pollutionMeasurement = pollutionData.getPm10();
            double avg = (pollutionMeasurement + pollutionData.getPm10()) / 2;
            pollutionArea.append("Average Pm10 = " + avg + "\n");
            prevTemp = avg;


        }

    }
}
