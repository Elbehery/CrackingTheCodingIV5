package designpattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class Singleton {

    private volatile static Singleton singletonInstance;
    private int counter;

    private Singleton() {

    }

    public void increaseCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static Singleton getSingletonInstance() {

        if (singletonInstance == null) {
            synchronized (Singleton.class) {
                singletonInstance = new Singleton();
            }
        }

        return singletonInstance;
    }
}
