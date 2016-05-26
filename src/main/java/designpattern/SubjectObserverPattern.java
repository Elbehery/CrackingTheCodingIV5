package designpattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class SubjectObserverPattern {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getSingletonInstance();

        System.out.println(singleton.getCounter());

        singleton.increaseCounter();
        singleton.increaseCounter();
        singleton.increaseCounter();

        System.out.println(singleton.getCounter());

        Singleton singleton1 = Singleton.getSingletonInstance();


        singleton1.increaseCounter();

        System.out.println(singleton.getCounter());


    }
}
