package exceptionalHandling;

public class DivisionWithTryCatch {
    public static int divide(int numerator, int denominator) {
        try {
            return numerator / denominator;
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero is not allowed.");
            return -1; // Return a special value to indicate an error
        }
    }

    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        int result = divide(numerator, denominator);

        if (result != -1) {
            System.out.println("Result: " + result);
        }
    }
}
