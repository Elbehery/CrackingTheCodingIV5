package designpattern.observerPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public interface Subject {


    void addObserver(Observer observer);
    boolean removeObserver(Observer observer);
    void notifyObservers();


}
