package designpattern.observerPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class ConcreteObserver implements Observer {

    private Subject subject;

    public ConcreteObserver(Subject subject) {

        this.subject = subject;
    }

    public void update() {

        System.out.println("********** UPDATED **************");
    }

    public void subscribe() {
        this.subject.addObserver(this);
    }

    public void unSubscribe() {

        this.subject.removeObserver(this);
    }
}
