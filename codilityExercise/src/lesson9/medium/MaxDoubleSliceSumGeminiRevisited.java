package lesson9.medium;

//A non-empty array A consisting of N integers is given.
//
//A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
//
//The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
//
//For example, array A such that:
//
//    A[0] = 3
//    A[1] = 2
//    A[2] = 6
//    A[3] = -1
//    A[4] = 4
//    A[5] = 5
//    A[6] = -1
//    A[7] = 2
//contains the following example double slices:
//
//double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
//double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
//double slice (3, 4, 5), sum is 0.
//The goal is to find the maximal sum of any double slice.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
//
//For example, given:
//
//    A[0] = 3
//    A[1] = 2
//    A[2] = 6
//    A[3] = -1
//    A[4] = 4
//    A[5] = 5
//    A[6] = -1
//    A[7] = 2
//the function should return 17, because no double slice of array A has a sum of greater than 17.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [3..100,000];
//each element of array A is an integer within the range [−10,000..10,000].
//
//To solve this problem, you can use dynamic programming to compute the maximum sum of slices ending at each position and another array for the maximum sum of slices starting at each position.
//        Then, iterate through each possible middle element of the double slice and find the maximum sum




public class MaxDoubleSliceSumGeminiRevisited {
    /**
     * Calculates the maximal sum of any double slice in the array A.
     *
     * @param A A non-empty array of N integers.
     * @return The maximal sum of any double slice.
     */
    public int solution(int[] A) {
        // N is the number of elements in the input array.
        int N = A.length;

        // A double slice requires at least 3 elements (X, Y, Z).
        // If N is 3 or less, no valid double slice can be formed, so the sum is 0.
        if (N <= 3) {
            return 0;
        }

        // `maxEndingHere` will store the maximum sum of a slice ending at index i.
        // This corresponds to the first part of the double slice: A[X+1] + ... + A[Y-1].
        // The slice must have a positive sum, so we take max(0, ...).
        int[] maxEndingHere = new int[N];

        // `maxStartingHere` will store the maximum sum of a slice starting at index i.
        // This corresponds to the second part of the double slice: A[Y+1] + ... + A[Z-1].
        // The slice must have a positive sum, so we take max(0, ...).
        int[] maxStartingHere = new int[N];

        // --- First Pass: Calculate maxEndingHere (from left to right) ---
        // We iterate from the second element (index 1) up to the second-to-last (N-2).
        // The boundaries A[0] and A[N-1] cannot be part of the sum.
        for (int i = 1; i < N - 1; i++) {
            // The maximum sum ending at `i` is either:
            // 1. The maximum sum ending at the previous element `i-1` plus the current element `A[i]`.
            // 2. Just the current element `A[i]` if the previous sum was negative.
            // We use Math.max(0, ...) to ensure that we don't carry over negative sums.
            // A slice can start fresh if the preceding part is detrimental.
            maxEndingHere[i] = Math.max(0, maxEndingHere[i - 1] + A[i]);
        }

        // --- Second Pass: Calculate maxStartingHere (from right to left) ---
        // We iterate from the second-to-last element (N-2) down to the second element (1).
        // The boundaries A[0] and A[N-1] cannot be part of the sum.
        for (int i = N - 2; i > 0; i--) {
            // The maximum sum starting at `i` is either:
            // 1. The maximum sum starting at the next element `i+1` plus the current element `A[i]`.
            // 2. Just the current element `A[i]` if the next sum was negative.
            // Again, we use Math.max(0, ...) to reset the sum if it becomes negative.
            maxStartingHere[i] = Math.max(0, maxStartingHere[i + 1] + A[i]);
        }

        // --- Third Pass: Find the maximal double slice sum ---
        int maxDoubleSliceSum = 0;

        // We iterate through all possible middle indices `Y` of the double slice.
        // `Y` can range from 1 to N-2.
        for (int i = 1; i < N - 1; i++) {
            // For each possible split point `Y` (at index `i`), the total sum is the sum
            // of the best slice ending just before it (`maxEndingHere[i-1]`) and the
            // best slice starting just after it (`maxStartingHere[i+1]`).
            int currentSum = maxEndingHere[i - 1] + maxStartingHere[i + 1];

            // We update the overall maximum sum found so far.
            if (currentSum > maxDoubleSliceSum) {
                maxDoubleSliceSum = currentSum;
            }
        }

        return maxDoubleSliceSum;
    }
    public static void main(String[] args) {
        int result1 = (new MaxDoubleSliceSumGeminiRevisited()).solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2});
        System.out.println("MaxDoubleSliceSum: " + result1);

    }
}
//This algorithm has a time complexity of O(N) as it iterates through the array three times sequentially.
// The three passes are for computing the maximum sum of slices ending at each position,
// the maximum sum of slices starting at each position, and finding the maximum double slice sum.
//
//Keep in mind that the indices for slices are adjusted to exclude the first and last elements, as the definition excludes the endpoints for a double slice.