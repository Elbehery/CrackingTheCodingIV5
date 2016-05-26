package designpattern.observerPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class Test {
    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();

        new ConcreteObserver(subject).subscribe();
        new ConcreteObserver(subject).subscribe();
        new ConcreteObserver(subject).subscribe();
        subject.setState(1);
        subject.setState(2);
        subject.setState(3);

    }
}
