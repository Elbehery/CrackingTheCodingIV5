package designpattern.factoryPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class ShapeFactory {

    public static Shape getShape(String type) {

        if (type == null)
            throw new NullPointerException();

        Shape shape = null;

        if (type.toLowerCase().equals("circle"))
            shape = new Circle();
        else if (type.toLowerCase().equals("rectangle"))
            shape = new Rectangle();
        else if (type.toLowerCase().equals("square"))
            shape = new Square();


        return shape;
    }
}
