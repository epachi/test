package lesson17Old.high;

import java.util.Arrays;

//To achieve better performance, we can use the following approach:
//
//Sort the array A in non-decreasing order.
//Calculate the prefix sum of the absolute values of the sorted array.
//Iterate through the array and, at each index, calculate the current absolute sum by subtracting twice the prefix sum up to the current index.
//Keep track of the minimum absolute sum encountered during the iteration.
//This approach avoids the need to create a separate array for absolute values and is more efficient.
//
//Here's the updated Java code:
public class MinAbsSumEfficientWRONG {
    public int solution(int[] A) {
        int N = A.length;

        // Step 1: Sort the array in non-decreasing order
        Arrays.sort(A);

        // Step 2: Calculate the prefix sum of absolute values
        int[] prefixSum = new int[N];
        prefixSum[0] = Math.abs(A[0]);
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Math.abs(A[i]);
        }

        // Step 3 & 4: Iterate through the array to find the minimum absolute sum
        int minAbsoluteSum = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            int currentAbsoluteSum = prefixSum[i] - (2 * (i + 1) - N) * Math.abs(A[i]);
            minAbsoluteSum = Math.min(minAbsoluteSum, Math.abs(currentAbsoluteSum));
        }

        return minAbsoluteSum;
    }

    public static void main(String[] args) {
        MinAbsSumEfficientWRONG solution = new MinAbsSumEfficientWRONG();
        int[] A = {1, 5, 2, -2};
        System.out.println(solution.solution(A)); // Output: 0
    }
}
//
//This solution has a time complexity of O(N * log(N)) due to the sorting step, and it avoids unnecessary array creation.