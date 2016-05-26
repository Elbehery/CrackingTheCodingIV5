package designpattern.commandPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class Stock {

    private String name;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void buy() {

        System.out.println("BUY"
        );
    }

    public void sell() {
        System.out.println("SELL");
    }
}
