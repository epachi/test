package myLesson1;

public class MergeSort {

    /**
     * Main merge sort method that initiates the sorting process
     * @param arr The array to be sorted
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Base case: array is already sorted
        }

        int[] temp = new int[arr.length];
        mergeSortHelper(arr, temp, 0, arr.length - 1);
    }

    /**
     * Recursive helper method that divides the array and calls merge
     * @param arr Original array
     * @param temp Temporary array for merging
     * @param left Left boundary (inclusive)
     * @param right Right boundary (inclusive)
     */
    private static void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Prevents integer overflow

            // Recursively sort left half
            mergeSortHelper(arr, temp, left, mid);

            // Recursively sort right half
            mergeSortHelper(arr, temp, mid + 1, right);

            // Merge the sorted halves
            merge(arr, temp, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray
     * @param arr Original array
     * @param temp Temporary array for merging
     * @param left Start of left subarray
     * @param mid End of left subarray / Start of right subarray - 1
     * @param right End of right subarray
     */
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy elements to temp array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      // Pointer for left subarray
        int j = mid + 1;   // Pointer for right subarray
        int k = left;      // Pointer for merged array

        // Merge elements back into arr[left..right]
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left subarray
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // Copy remaining elements from right subarray
        while (j <= right) {
            arr[k] = temp[j];
            j++;
            k++;
        }
    }

    /**
     * Utility method to print array
     * @param arr Array to print
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Main method to demonstrate merge sort
     */
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50, 42};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);

        // Test with edge cases
        int[] emptyArr = {};
        int[] singleElement = {42};
        int[] duplicates = {5, 2, 8, 2, 9, 1, 5};

        System.out.println("\nTesting edge cases:");

        mergeSort(emptyArr);
        System.out.print("Empty array: ");
        printArray(emptyArr);

        mergeSort(singleElement);
        System.out.print("Single element: ");
        printArray(singleElement);

        System.out.print("Array with duplicates before sorting: ");
        printArray(duplicates);
        mergeSort(duplicates);
        System.out.print("Array with duplicates after sorting: ");
        printArray(duplicates);
    }
}
