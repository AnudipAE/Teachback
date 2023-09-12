package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class SortingMethods {

	// Helper method to generate a random array of integers
	public static int[] generateRandomArray(int size) {
		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(100000); // Adjust the range as needed
		}
		return arr;
	}

	// bubble sort method
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 1; i < n; i++) {
				if (arr[i - 1] > arr[i]) {
					// Swap arr[i-1] and arr[i]
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
					swapped = true;
				}
			}
			n--;
		} while (swapped);
	}

	// selection sort method
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			// Swap arr[i] and arr[minIndex]
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	// insertion sort method
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	// merge sort method
	public static void mergeSort(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
	}

	private static void merge(int[] arr, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		while (i < left.length) {
			arr[k++] = left[i++];
		}
		while (j < right.length) {
			arr[k++] = right[j++];
		}
	}

	// quick sort method
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(arr, low, high);
			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}
	}

	// partition method for quick sort
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	// heap sort method
	public static void heapSort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	// heapily method for heap sort
	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, n, largest);
		}
	}

	// radix sort method
	public static void radixSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countingSortByDigit(arr, exp);
		}
	}

	// counting by digit method for radix sort
	private static void countingSortByDigit(int[] arr, int exp) {
		int n = arr.length;
		int[] output = new int[n];
		int[] count = new int[10];

		Arrays.fill(count, 0);

		for (int i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		for (int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

	// counting sort method
	public static void countingSort(int[] arr) {
		int n = arr.length;
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max - min + 1;

		int[] count = new int[range];
		int[] output = new int[n];

		for (int i = 0; i < n; i++) {
			count[arr[i] - min]++;
		}

		for (int i = 1; i < range; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}

		for (int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

}
