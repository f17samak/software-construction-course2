package lec10observer.weatherorama.ver1;


import java.util.ArrayList;
import java.util.List;

public class Subject2 {

    private List<Observer> observers = new ArrayList<>();

    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(this);
        }
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}
