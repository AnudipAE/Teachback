package sortingAlgos;

public class BubbleSort {

    // Main BubbleSort function
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Flag to optimize the algorithm by detecting if any swaps occurred in the pass
            boolean swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap them if they are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no two elements were swapped in this pass, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 66, 98, 5, 6};
        
        System.out.println("Original Array:");
        printArray(arr);
        
        bubbleSort(arr);
        
        System.out.println("Sorted Array:");
        printArray(arr);
    }

    // Utility function to print an array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
