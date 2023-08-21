package com.factory.main;

//Step 1: Define the Product interface
interface Shape {
 void draw();
}

//Step 2: Implement ConcreteProducts
class Circle implements Shape {
 public void draw() {
     System.out.println("Drawing a circle");
 }
}

class Square implements Shape {
 public void draw() {
     System.out.println("Drawing a square");
 }
}

//Step 3: Define the Creator abstract class
abstract class ShapeFactory {
 abstract Shape factoryMethod();
 
 void someOperation() {
     Shape shape = factoryMethod();
     shape.draw();
 }
}

//Step 4: Implement ConcreteCreators
class CircleFactory extends ShapeFactory {
 Shape factoryMethod() {
     return new Circle();
 }
}

class SquareFactory extends ShapeFactory {
 Shape factoryMethod() {
     return new Square();
 }
}


