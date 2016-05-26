package designpattern.decoratorPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape shape;

    public ShapeDecorator(Shape shape) {

        this.shape = shape;
    }


    public void draw() {

        shape.draw();
    }
}
