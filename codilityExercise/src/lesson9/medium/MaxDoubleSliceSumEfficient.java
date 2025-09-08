package lesson9.medium;

//Certainly! Here's a more efficient solution that computes the maximum sum of double slices in a single pass:
public class MaxDoubleSliceSumEfficient {
    public int solution(int[] A) {
        int N = A.length;

        if (N == 3) {
            // If there are only three elements, there is no double slice
            return 0;
        }

        int[] maxEnding = new int[N];
        int[] maxStarting = new int[N];

        // Calculate the maximum sum of slices ending at each position
        for (int i = 1; i < N - 1; i++) {
            maxEnding[i] = Math.max(maxEnding[i - 1] + A[i], 0);
        }

        // Calculate the maximum sum of slices starting at each position
        for (int i = N - 2; i > 0; i--) {
            maxStarting[i] = Math.max(maxStarting[i + 1] + A[i], 0);
        }

        int maxDoubleSliceSum = 0;

        // Find the maximum double slice sum in a single pass
        for (int i = 1; i < N - 1; i++) {
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, maxEnding[i - 1] + maxStarting[i + 1]);
        }

        return maxDoubleSliceSum;
    }
}

//This solution maintains the efficiency of O(N) time complexity while avoiding redundant calculations.
// The final loop iterates through the array only once to find the maximum double slice sum.
// The additional check for N == 3 is included to handle the special case where there are only three elements in the array.