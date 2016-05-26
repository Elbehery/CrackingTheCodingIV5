package designpattern.commandPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class SellStock implements Command {

    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    public void execute() {

        this.stock.sell();

    }
}
