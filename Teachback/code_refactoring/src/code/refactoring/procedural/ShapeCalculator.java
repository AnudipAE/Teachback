package code.refactoring.procedural;

public class ShapeCalculator {
    public static double calculateCircleArea(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        return Math.PI * Math.pow(radius, 2);
    }

    public static double calculateTriangleArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be positive.");
        }
        return 0.5 * base * height;
    }

    public static double calculateRectangleArea(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive.");
        }
        return length * width;
    }

    public static void main(String[] args) {
        try {
            double circleArea = calculateCircleArea(5);
            System.out.println("Circle Area: " + circleArea);

            double triangleArea = calculateTriangleArea(4, 6);
            System.out.println("Triangle Area: " + triangleArea);

            double rectangleArea = calculateRectangleArea(3, 7);
            System.out.println("Rectangle Area: " + rectangleArea);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

