package exercise4AlgoSkills.medium;
//
//An array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//    that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.
//
//        For example, in the following array:
//
//        A[0] = -1 A[1] = 6 A[2] = 3
//        A[3] =  4 A[4] = 7 A[5] = 4
//        there are four inversions:
//
//        (1,2)  (1,3)  (1,5)  (4,5)
//        so the function should return 4.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..100,000];
//        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

//To solve this problem efficiently, we can use a modified merge sort algorithm to count the inversions during the merging step.
//        The idea is to keep track of the inversions while merging two sorted halves of the array.
public class ArrayInversionCountRevisited {
    public int solution(int[] A) {
        int[] temp = new int[A.length];
        return mergeSort(A, temp, 0, A.length - 1);
    }

    private int mergeSort(int[] A, int[] temp, int left, int right) {
        if (left >= right) {
            return 0; // Base case: single element is already sorted
        }

        int mid = left + (right - left) / 2;
        int inversions = 0;

        // Recursively sort and count inversions in the left and right halves
        inversions += mergeSort(A, temp, left, mid);
        inversions += mergeSort(A, temp, mid + 1, right);

        // Merge the sorted halves and count inversions during the merge
        inversions += merge(A, temp, left, mid, right);

        // Check for overflow
        if (inversions > 1_000_000_000) {
            return -1;
        }

        return inversions;
    }

    private int merge(int[] A, int[] temp, int left, int mid, int right) {
        int i = left;    // Index for the left subarray
        int j = mid + 1; // Index for the right subarray
        int k = left;    // Index for the merged array
        int inversions = 0;

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
                inversions += mid - i + 1; // Count inversions
            }
        }

        // Copy the remaining elements from the left subarray
        while (i <= mid) {
            temp[k++] = A[i++];
        }

        // Copy the remaining elements from the right subarray
        while (j <= right) {
            temp[k++] = A[j++];
        }

        // Copy the merged elements back to the original array
        System.arraycopy(temp, left, A, left, right - left + 1);        //<=====System.arraycopy

        return inversions;
    }

    public static void main(String[] args) {
        ArrayInversionCountRevisited solution = new ArrayInversionCountRevisited();

        // Example
        int[] A = {-1, 6, 3, 4, 7, 4};
        System.out.println(solution.solution(A)); // Output: 4
    }
}

//    This solution uses a divide-and-conquer approach to efficiently count inversions during the merge step.
//        The mergeSort method recursively divides the array into halves, sorts them, and counts inversions during merging.
//        The merge method merges two sorted subarrays while counting inversions.
//        The final result is the total number of inversions in the array. The solution checks for overflow and returns -1 if the count exceeds 1,000,000,000.