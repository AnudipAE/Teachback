package code.refactoring.oops;

public class ShapeCalculator {
    public static void main(String[] args) {
        try {
            Shape circle = new Circle(5);
            double circleArea = circle.calculateArea();
            System.out.println("Circle Area: " + circleArea);

            Shape triangle = new Triangle(4, 6);
            double triangleArea = triangle.calculateArea();
            System.out.println("Triangle Area: " + triangleArea);

            Shape rectangle = new Rectangle(3, 7);
            double rectangleArea = rectangle.calculateArea();
            System.out.println("Rectangle Area: " + rectangleArea);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

