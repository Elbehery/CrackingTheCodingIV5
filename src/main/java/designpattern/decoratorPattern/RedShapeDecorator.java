package designpattern.decoratorPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape decoratedShape) {

        System.out.println("BORDER COLOR : RED");

    }

}
