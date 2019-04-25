package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class ForcastDisplay implements Observer {

    private double prevTemp;
    private double maxTemp;
    private double minTemp;
    private double ForcastTemp;
    ArrayList<Double> T = new ArrayList<Double>();

    private JFrame frame;
    private JTextArea area;

    public ForcastDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Forcast Temperature Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.GREEN);
        area.setText(" Forcast Temperature Condition:\n");

    }

    @Override
    public void update(Subject2 data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;
            area.setBackground(Color.GREEN);
            area.setText("Forcast Temperature Condition:\n");
            prevTemp =  weatherData.getTemperature();
            T.add(prevTemp);
            double maxTemp = Collections.max(T);
            double minTemp = Collections.min(T);
            ForcastTemp = (maxTemp + minTemp) / 2;
            area.append("Temperature = " + ForcastTemp);

        }
    }

}
