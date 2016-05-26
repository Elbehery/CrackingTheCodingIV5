package designpattern.decoratorPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class Tester {

    public static void main(String[] args) {


        Circle circle = new Circle();
        //circle.draw();

        Rectangle rectangle = new Rectangle();
        //rectangle.draw();

        RedShapeDecorator redCircle = new RedShapeDecorator(circle);
        redCircle.draw();

        RedShapeDecorator redRect = new RedShapeDecorator(rectangle);
        redRect.draw();

    }
}
