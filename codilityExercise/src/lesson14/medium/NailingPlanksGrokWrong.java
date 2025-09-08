package lesson14.medium;

//
//Certainly! We can further optimize the solution by using the concept of prefix sums.
//        We will create an array to represent the cumulative count of nails at each position.
//        This array will help us quickly determine the count of nails in a given range.

import java.util.ArrayList;
import java.util.List;

//Use binary Search
public class NailingPlanksGrokWrong {
    public int solution(int[] A, int[] B, int[] C) {
        int N = A.length; // Number of planks
        int M = C.length; // Number of nails

        // Binary search for the minimum number of nails
        int left = 1, right = M, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid integer overflow

            // Check if 'mid' nails can cover all planks
            if (canNailAllPlanks(A, B, C, mid)) {
                result = mid; // Store the current valid result
                right = mid - 1; // Try for fewer nails
            } else {
                left = mid + 1; // Need more nails
            }
        }

        return result;
    }

    private boolean canNailAllPlanks(int[] A, int[] B, int[] C, int numNails) {
        int maxPos = 2 * C.length; // Maximum possible position (based on constraints)
        int[] nailed = new int[maxPos + 1]; // Array to mark nailed positions

        // Mark positions covered by the first 'numNails' nails
        for (int i = 0; i < numNails; i++) {
            if (C[i] <= maxPos) {
                nailed[C[i]] = 1;
            }
        }

        // Create a prefix sum to check if a range is nailed
        int[] prefixSum = new int[maxPos + 1];
        for (int i = 1; i <= maxPos; i++) {
            prefixSum[i] = prefixSum[i - 1] + nailed[i];
        }

        // Check each plank
        for (int i = 0; i < A.length; i++) {
            // If no nails in the range [A[i], B[i]], the plank is not nailed
            if (prefixSum[B[i]] - (A[i] > 0 ? prefixSum[A[i] - 1] : 0) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NailingPlanksYoutube solution = new NailingPlanksYoutube();
        int [] A = {1, 4, 5, 8};
        int [] B = {4, 5, 9, 10};
        int [] C = {4, 6, 7, 10, 2};

        int minNumOfNails = solution.solution(A, B, C);

        System.out.println("minNumOfNails==>" + minNumOfNails);

    }
}


//This solution has a time complexity of O((N+M) + (N+M) * log(M)),
// which is more efficient than the previous solution for larger datasets.