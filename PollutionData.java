package lec10observer.weatherorama.ver1;



public class PollutionData extends Subject2 {


    private double pm10;
    private double pm2_5;


    public double getPm10() {
        return pm10;
    }

    public double getPm2_5() {
        return pm2_5;
    }

    public void setMeasurement(double Pm2_5, double Pm10) {
        pm2_5 = Pm2_5;
        pm10 = Pm10;
        notifyObservers();
    }
}
