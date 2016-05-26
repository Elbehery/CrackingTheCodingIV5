package designpattern.commandPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class Tester {

    public static void main(String[] args) {

        Stock receiver = new Stock();

        BuyStock buyStock = new BuyStock(receiver);
        SellStock sellStock = new SellStock(receiver);

        Broker broker = new Broker();
        broker.takeCommand(buyStock);
        broker.takeCommand(sellStock);

        broker.placeCommands();
    }
}
