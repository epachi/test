package lesson13Old.medium;

//To achieve better performance, we can use an optimized approach that avoids recomputing Fibonacci numbers for each query.
// Instead, we can use a single pass to calculate the Fibonacci numbers up to the maximum number of rungs and store them in an array.
// Then, we can use these precomputed values to answer the queries. This reduces the time complexity significantly.

import java.util.Arrays;

public class LadderEfficient {
    public int[] solution(int[] A, int[] B) {
        int maxRungs = 0;
        for (int i = 0; i < A.length; i++) {
            maxRungs = Math.max(maxRungs, A[i]);
        }

        // Compute the Fibonacci numbers up to the maximum number of rungs
        int[] fibonacci = calculateFibonacci(maxRungs + 2);

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            // Use precomputed Fibonacci numbers
            result[i] = fibonacci[A[i] + 1] & ((1 << B[i]) - 1);
        }

        return result;
    }

    // Helper method to calculate Fibonacci numbers
    private int[] calculateFibonacci(int n) {
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) & ((1 << 30) - 1);
        }

        return fibonacci;
    }
}

//In this solution, the bitwise AND operation (&) is used instead of the modulo operation,
// taking advantage of the fact that 2^B is equivalent to (1 << B).
// This optimization can significantly improve the performance of the solution.