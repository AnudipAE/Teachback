package com.factory.main;

//Step 5: Client code
public class FactoryPattern {
	public static void main(String[] args) {
	   ShapeFactory circleFactory = new CircleFactory();
	   ShapeFactory squareFactory = new SquareFactory();
	   
	   circleFactory.someOperation(); // Output: Drawing a circle
	   squareFactory.someOperation(); // Output: Drawing a square
	}
}
