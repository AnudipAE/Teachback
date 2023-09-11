package exceptionalHandling;

public class DivisionWithReturnValue {
    public static int divide(int numerator, int denominator) {
        if (denominator == 0) {
            return -1; // Return a special value to indicate an error
        }
        return numerator / denominator;
    }

    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        int result = divide(numerator, denominator);

        if (result == -1) {
            System.err.println("Error: Division by zero is not allowed.");
        } else {
            System.out.println("Result: " + result);
        }
    }
}
