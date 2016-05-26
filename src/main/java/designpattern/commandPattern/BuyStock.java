package designpattern.commandPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class BuyStock implements Command {

    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }


    public void execute() {

        this.stock.buy();
    }
}
