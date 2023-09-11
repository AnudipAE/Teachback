package sortingAlgorithms;

import java.util.Arrays;

public class SortingAlgorithmMain {

	public static void main(String[] args) {

		int[] arr = SortingMethods.generateRandomArray(10000); // Change the array size as needed
		int[] arrCopy;

		// Bubble Sort
		arrCopy = Arrays.copyOf(arr, arr.length);
		long startTime = System.nanoTime();
		SortingMethods.bubbleSort(arrCopy);
		long endTime = System.nanoTime();
		long bubbleSortTime = endTime - startTime;
		System.out.println("Bubble Sort Time: " + bubbleSortTime + " nanoseconds");

		// Selection Sort
		arrCopy = Arrays.copyOf(arr, arr.length);
		startTime = System.nanoTime();
		SortingMethods.selectionSort(arrCopy);
		endTime = System.nanoTime();
		long selectionSortTime = endTime - startTime;
		System.out.println("Selection Sort Time: " + selectionSortTime + " nanoseconds");

		// Insertion Sort
		arrCopy = Arrays.copyOf(arr, arr.length);
		startTime = System.nanoTime();
		SortingMethods.insertionSort(arrCopy);
		endTime = System.nanoTime();
		long insertionSortTime = endTime - startTime;
		System.out.println("Insertion Sort Time: " + insertionSortTime + " nanoseconds");

		// Merge Sort
		arrCopy = Arrays.copyOf(arr, arr.length);
		startTime = System.nanoTime();
		SortingMethods.mergeSort(arrCopy);
		endTime = System.nanoTime();
		long mergeSortTime = endTime - startTime;
		System.out.println("Merge Sort Time: " + mergeSortTime + " nanoseconds");

		// Quick Sort
		arrCopy = Arrays.copyOf(arr, arr.length);
		startTime = System.nanoTime();
		SortingMethods.quickSort(arrCopy, 0, arrCopy.length - 1);
		endTime = System.nanoTime();
		long quickSortTime = endTime - startTime;
		System.out.println("Quick Sort Time: " + quickSortTime + " nanoseconds");

		// Heap Sort
		arrCopy = Arrays.copyOf(arr, arr.length);
		startTime = System.nanoTime();
		SortingMethods.heapSort(arrCopy);
		endTime = System.nanoTime();
		long heapSortTime = endTime - startTime;
		System.out.println("Heap Sort Time: " + heapSortTime + " nanoseconds");

		// Radix Sort
		arrCopy = Arrays.copyOf(arr, arr.length);
		startTime = System.nanoTime();
		SortingMethods.radixSort(arrCopy);
		endTime = System.nanoTime();
		long radixSortTime = endTime - startTime;
		System.out.println("Radix Sort Time: " + radixSortTime + " nanoseconds");

		// Counting Sort
		arrCopy = Arrays.copyOf(arr, arr.length);
		startTime = System.nanoTime();
		SortingMethods.countingSort(arrCopy);
		endTime = System.nanoTime();
		long countingSortTime = endTime - startTime;
		System.out.println("Counting Sort Time: " + countingSortTime + " nanoseconds");
	}

}
