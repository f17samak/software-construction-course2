package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class HumidityAverageDisplay implements Observer {


    private double prevTemp;
    private double prevHumid;

    private JFrame frame;
    private JTextArea area;

    public HumidityAverageDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Humidity Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.BLUE);
        area.setText(" Humidity Average Condition:\n");

    }

    @Override
    public void update(Subject2 data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;
            area.setBackground(Color.BLUE);
            area.setText("Humidity Average Condition:\n");
            if (prevHumid == 0)
                prevHumid = weatherData.getHumidity();
            double avg = (prevHumid + weatherData.getHumidity()) / 2;
            area.append("Humidity = " + avg + "\n");
            prevHumid = avg;
        }




    }


}
