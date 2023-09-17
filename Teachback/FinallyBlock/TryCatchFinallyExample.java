package Programs;

import java.io.IOException;

public class TryCatchFinallyExample {
	public static void main(String[] args) {
    	try {
        	// Code that might throw an exception
        	int result = divide(10, 0);
            System.out.println("Result: " + result);
    	} catch (ArithmeticException e) {
        	// Exception handling code
            System.out.println("Error: Division by zero");
    	} 
           finally {
        	// Code that always executes, for cleanup or other purposes
            System.out.println("Finally block executed");
    	}
      }

    // Define the divide method
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return dividend / divisor;
    }
}

