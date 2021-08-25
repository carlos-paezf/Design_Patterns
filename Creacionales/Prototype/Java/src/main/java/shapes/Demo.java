package shapes;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.x = 10;
        rectangle.y = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }
    
    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        shapes.forEach(shape -> {
            shapesCopy.add(shape.clone());
        });

        for (int index=0; index < shapes.size(); index++) {
            if (shapes.get(index) != shapesCopy.get(index)) {
                System.out.println(index + ": Shapes are different objects (yay!)");
                if (shapes.get(index).equals(shapesCopy.get(index))) {
                    System.out.println(index + ": And they are identical (yay!)");
                } else {
                    System.out.println(index + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(index + ": Shape Objects are the same (booo!)");
            }
        }
    }
}
