package myLesson1;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    /**
     * Main quicksort method - sorts the entire array
     *
     * @param arr the array to be sorted
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursive quicksort implementation
     *
     * @param arr  the array to be sorted
     * @param low  starting index
     * @param high ending index
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partition method using Lomuto partition scheme
     *
     * @param arr  the array to partition
     * @param low  starting index
     * @param high ending index
     * @return the final position of the pivot element
     */
    private static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr[high];

        // Index of smaller element, indicates the right position of pivot found so far
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Place pivot in its correct position
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Utility method to swap two elements in an array
     *
     * @param arr the array
     * @param i   first index
     * @param j   second index
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Alternative implementation using randomized pivot for better average performance
     *
     * @param arr the array to be sorted
     */
    public static void quickSortRandomized(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSortRandomized(arr, 0, arr.length - 1);
    }

    private static void quickSortRandomized(int[] arr, int low, int high) {
        if (low < high) {
            // Randomly choose pivot and swap with last element
            Random rand = new Random();
            int randomIndex = low + rand.nextInt(high - low + 1);
            swap(arr, randomIndex, high);

            int pivotIndex = partition(arr, low, high);
            quickSortRandomized(arr, low, pivotIndex - 1);
            quickSortRandomized(arr, pivotIndex + 1, high);
        }
    }

    // Test methods
    public static void main(String[] args) {
        System.out.println("=== QuickSort Test Suite ===\n");

        testBasicSorting();
        testEdgeCases();
        testLargeArray();
        testRandomizedVersion();
        testPerformanceComparison();

        System.out.println("All tests completed!");
    }

    private static void testBasicSorting() {
        System.out.println("1. Testing Basic Sorting:");

        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original: " + Arrays.toString(arr1));
        quickSort(arr1);
        System.out.println("Sorted:   " + Arrays.toString(arr1));
        System.out.println("Is sorted: " + isSorted(arr1));

        int[] arr2 = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        System.out.println("\nOriginal: " + Arrays.toString(arr2));
        quickSort(arr2);
        System.out.println("Sorted:   " + Arrays.toString(arr2));
        System.out.println("Is sorted: " + isSorted(arr2));
        System.out.println();
    }

    private static void testEdgeCases() {
        System.out.println("2. Testing Edge Cases:");

        // Empty array
        int[] empty = {};
        quickSort(empty);
        System.out.println("Empty array test passed: " + (empty.length == 0));

        // Single element
        int[] single = {42};
        quickSort(single);
        System.out.println("Single element test passed: " + (single[0] == 42));

        // Already sorted
        int[] sorted = {1, 2, 3, 4, 5};
        quickSort(sorted);
        System.out.println("Already sorted test passed: " + isSorted(sorted));

        // Reverse sorted
        int[] reverse = {5, 4, 3, 2, 1};
        quickSort(reverse);
        System.out.println("Reverse sorted test passed: " + isSorted(reverse));

        // Duplicates
        int[] duplicates = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        quickSort(duplicates);
        System.out.println("Duplicates test passed: " + isSorted(duplicates));
        System.out.println("Duplicates result: " + Arrays.toString(duplicates));
        System.out.println();
    }

    private static void testLargeArray() {
        System.out.println("3. Testing Large Array:");

        int[] large = new int[1000];
        Random rand = new Random(12345); // Fixed seed for reproducible results

        for (int i = 0; i < large.length; i++) {
            large[i] = rand.nextInt(1000);
        }

        System.out.println("Generated array of " + large.length + " random elements");
        long startTime = System.nanoTime();
        quickSort(large);
        long endTime = System.nanoTime();

        System.out.println("Large array test passed: " + isSorted(large));
        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms");
        System.out.println();
    }

    private static void testRandomizedVersion() {
        System.out.println("4. Testing Randomized QuickSort:");

        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original: " + Arrays.toString(arr));
        quickSortRandomized(arr);
        System.out.println("Sorted:   " + Arrays.toString(arr));
        System.out.println("Randomized version test passed: " + isSorted(arr));
        System.out.println();
    }

    private static void testPerformanceComparison() {
        System.out.println("5. Performance Comparison:");

        // Test with worst-case scenario for regular quicksort (already sorted)
        int[] worstCase1 = new int[5000];
        int[] worstCase2 = new int[5000];

        for (int i = 0; i < 5000; i++) {
            worstCase1[i] = worstCase2[i] = i; // Already sorted - worst case for basic quicksort
        }

        // Test regular quicksort
        long startTime = System.nanoTime();
        quickSort(worstCase1);
        long regularTime = System.nanoTime() - startTime;

        // Test randomized quicksort
        startTime = System.nanoTime();
        quickSortRandomized(worstCase2);
        long randomizedTime = System.nanoTime() - startTime;

        System.out.println("Regular QuickSort time: " + regularTime / 1_000_000.0 + " ms");
        System.out.println("Randomized QuickSort time: " + randomizedTime / 1_000_000.0 + " ms");
        System.out.println("Both arrays properly sorted: " + (isSorted(worstCase1) && isSorted(worstCase2)));
        System.out.println();
    }

    /**
     * Utility method to check if an array is sorted
     *
     * @param arr the array to check
     * @return true if sorted, false otherwise
     */
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}