package lesson13.medium;

//You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you can ascend by one or two rungs. More precisely:
//
//with your first step you can stand on rung 1 or 2,
//if you are on rung K, you can move to rungs K + 1 or K + 2,
//finally you have to stand on rung N.
//Your task is to count the number of different ways of climbing to the top of the ladder.
//
//For example, given N = 4, you have five different ways of climbing, ascending by:
//
//1, 1, 1 and 1 rung,
//1, 1 and 2 rungs,
//1, 2 and 1 rung,
//2, 1 and 1 rungs, and
//2 and 2 rungs.
//Given N = 5, you have eight different ways of climbing, ascending by:
//
//1, 1, 1, 1 and 1 rung,
//1, 1, 1 and 2 rungs,
//1, 1, 2 and 1 rung,
//1, 2, 1 and 1 rung,
//1, 2 and 2 rungs,
//2, 1, 1 and 1 rungs,
//2, 1 and 2 rungs, and
//2, 2 and 1 rung.
//The number of different ways can be very large, so it is sufficient to return the result modulo 2P, for a given integer P.
//
//Write a function:
//
//class Solution { public int[] solution(int[] A, int[] B); }
//
//that, given two non-empty arrays A and B of L integers, returns an array consisting of L integers specifying the consecutive answers;
// position I should contain the number of different ways of climbing the ladder with A[I] rungs modulo 2B[I].
//
//For example, given L = 5 and:
//
//    A[0] = 4   B[0] = 3
//    A[1] = 4   B[1] = 2
//    A[2] = 5   B[2] = 4
//    A[3] = 5   B[3] = 3
//    A[4] = 1   B[4] = 1
//the function should return the sequence [5, 1, 8, 0, 1], as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//L is an integer within the range [1..50,000];
//each element of array A is an integer within the range [1..L];
//each element of array B is an integer within the range [1..30].

class LadderClaudeAlgorithmIsEasyIfAcceptFibonacciTrend {
    public int[] solution(int[] A, int[] B) {
        int L = A.length;
        int[] result = new int[L];

        // Find the maximum N value to precompute Fibonacci numbers up to that point
        int maxN = 0;
        for (int n : A) {
            maxN = Math.max(maxN, n);
        }

        // Precompute Fibonacci numbers modulo 2^30 (largest possible modulus)
        // This way we can handle all queries efficiently
        long[] fib = new long[maxN + 1];
        if (maxN >= 1) fib[1] = 1;
        if (maxN >= 2) fib[2] = 2;

        long modulus = 1L << 30; // 2^30

        for (int i = 3; i <= maxN; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % modulus;
        }

        // Answer each query
        for (int i = 0; i < L; i++) {
            int n = A[i];
            int p = B[i];

            // Calculate 2^p
            long queryModulus = 1L << p; // 2^p

            // Get the result modulo 2^p
            result[i] = (int)(fib[n] % queryModulus);
        }

        return result;
    }

    public static void main(String[] args) {
        LadderClaudeAlgorithmIsEasyIfAcceptFibonacciTrend solution = new LadderClaudeAlgorithmIsEasyIfAcceptFibonacciTrend();
        int [] A = {4, 4, 5, 5, 1};
        int [] B = {3, 2, 4, 3, 1};

        int [] modCount = solution.solution(A, B);
        for (int i = 0 ; i < modCount.length ; i++) {
            System.out.println("==>" + modCount[i]);

        }
    }
}
//    This solution calculates the Fibonacci numbers up to the maximum number of rungs in the given set of queries.
//        It then uses the Fibonacci property to efficiently compute the number of ways for each query.
//        The results are stored in the result array and returned.
//        The modulo operation is applied to avoid overflow, and the bitwise shift (1 << B[i]) is used to compute the modulo 2^B[i].