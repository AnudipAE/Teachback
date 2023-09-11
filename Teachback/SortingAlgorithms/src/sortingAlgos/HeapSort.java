package sortingAlgos;

public class HeapSort {

    // Main HeapSort function
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root of the heap with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify a subtree rooted at node i
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // Check if the left child is larger than the root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // Check if the right child is larger than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If the largest element is not the root, swap them and recursively heapify
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 1, 15, 5, 6, 7};
        
        System.out.println("Original Array:");
        printArray(arr);
        
        heapSort(arr);
        
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

