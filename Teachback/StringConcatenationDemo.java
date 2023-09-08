package Programs;

public class StringConcatenationDemo {
    public static void main(String[] args) {
       
        String str1 = "Hello";
        System.out.println("Initial str1: " + str1);

        // Get the memory address of the initial str1
        int initialAddress = System.identityHashCode(str1);

        str1 = str1 + "hello";
        System.out.println("Concatenated str1: " + str1);

        // Get the memory address of the concatenated str1
        int newAddress = System.identityHashCode(str1);

        System.out.println("Initial Address: " + initialAddress);
        System.out.println("New Address: " + newAddress);
    }
}

