package code.refactoring.oops;

public class Rectangle extends Shape {
    private double length;
    private double width;

	public Rectangle(double length, double width) {
	    if (length <= 0 || width <= 0) {
	        throw new IllegalArgumentException("Length and width must be positive.");
	    }
	    this.length = length;
	    this.width = width;
	}
	
	@Override
	public double calculateArea() {
	    return length * width;
	}
}

