package designpattern.observerPattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mustafa on 03.04.16.
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers;
    private int state;
    private boolean stateChanged = false;

    public ConcreteSubject() {
        observers = new LinkedList<Observer>();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        stateChanged = true;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public boolean removeObserver(Observer observer) {

        return observers.remove(observer);
    }

    public void notifyObservers() {

        if (stateChanged) {
            for (Observer observer : observers)
                observer.update();
        }
    }
}
