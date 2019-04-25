package lec10observer.weatherorama.ver1;

public class Main {

    public static void main(String[] args) {
        // subject
        WeatherData data = new WeatherData();
        PollutionData pollutionData = new PollutionData();

        // observers
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        HumidityAverageDisplay humidityAverageDisplay = new HumidityAverageDisplay();
        ForcastDisplay forcastDisplay = new ForcastDisplay();

        // connect subject and observers
        data.registerObserver(currentConditionDisplay);
        data.registerObserver(statisticsDisplay);
        data.registerObserver(humidityAverageDisplay);
        data.registerObserver(forcastDisplay);

        pollutionData.registerObserver(currentConditionDisplay);
        pollutionData.registerObserver(statisticsDisplay);
        pollutionData.registerObserver(humidityAverageDisplay);
        pollutionData.registerObserver(forcastDisplay);

        // input receives new data from a user via System.in
        // whenever a user inputs new data, all observers are
        // updated
        InputUI inputUI = new InputUI();
        inputUI.receive(data, pollutionData);
    }
}
