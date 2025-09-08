package exercise3.hard;

//Bob once had an array A with N elements. Each element was a positive integer not exceeding M.
//
//        Bob wrote a program to find an array B, defined as follows. For every index J, let's find the biggest index K such that K < J and A[K] < A[J].
//        Then set B[J] = A[K]. If there is no such index K, then set B[J] = 0.
//        Intuitively, the J-th element of B contains the last value smaller than A[J] that appears before it, or 0 if there is no such element.
//
//        For example, let A = [2, 5, 3, 7, 9, 6]. Then B = [0, 2, 2, 3, 7, 3]. For instance, B[5] = 3, as A[5] is 6 and the last value before A[5] smaller than 6 is 3.
//
//        Bob computed an array B and then mistakenly deleted A. He now intends to find every valid array A from which his program would produce B.
//        Count the number of such arrays A. Since the answer could be very big, return it modulo 109+7.
//
//        Write a function:
//
//class Solution { public int solution(int[] B, int M); }
//
//that, given an integer M and an array B with N integers, returns the remainder from the division by 109+7 of the number of valid arrays A from which Bob would get B.
// You can assume that there is at least one such array.
//
//        For example, given: M = 4, B = [0, 2, 2] the function should return 3. The possible removed arrays A were [2, 3, 3], [2, 4, 3] and [2, 4, 4].
//
//        For the following data: M = 10, B = [0, 3, 5, 6] the function should return 4,
//        as the possible arrays A were [3, 5, 6, 7], [3, 5, 6, 8], [3, 5, 6, 9] and [3, 5, 6, 10].
//
//        For the following data: M = 105, B = [0, 0] there are 5000050000 possible arrays (the first element in array A can be anything in the range 1..105
//        and the second element can be either equal or smaller), so the function should return 49965 (as we are taking modulo 109+7).
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        M is an integer within the range [1..1,000,000,000];
//        each element of array B is an integer within the range [0..M];
//        there exists at least one valid array A from which Bob would get array B.

//To solve this problem, we can iterate through the array B and count the number of ways to choose the previous element for each element in B.
//        We can do this by maintaining a count of how many times each element has appeared before the current index.
public class ArrayRecoveryWrongSolution {
    public int solution(int[] B, int M) {        final int MOD = 1_000_000_007;
        int n = B.length;

        // dp[i] represents the number of valid arrays A[0..i-1]
        long[] dp = new long[n + 1];
        dp[0] = 1; // Empty array has 1 way

        // For each position i, track valid values for A[i]
        for (int i = 0; i < n; i++) {
            // A[i] must be greater than B[i] and at most M
            long validCount = (long) M - B[i];
            if (validCount <= 0) return 0; // No valid value for A[i]

            // Check constraints: if B[j] = A[i] for some j > i
            for (int j = i + 1; j < n; j++) {
                if (B[j] == 0) continue;
                // If B[j] = A[i], then A[i] must be <= A[k] for all i < k < j
                // We check if A[i] can be B[j]
                if (B[j] <= B[i] || B[j] > M) return 0; // Invalid B[j]

                // Find the last position k where B[k] = A[i]
                int last = -1;
                for (int k = i; k < j; k++) {
                    if (B[k] == B[j]) last = k;
                }
                // If last != i, then A[i] cannot be B[j]
                if (last != i && last != -1) {
                    validCount--;
                    if (validCount <= 0) return 0;
                }
            }

            // Number of ways to form A[0..i] = ways to form A[0..i-1] * valid values for A[i]
            dp[i + 1] = (dp[i] * validCount) % MOD;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {
        ArrayRecoveryWrongSolution solution = new ArrayRecoveryWrongSolution();

        // Example 1
        int M1 = 4;
        int[] B1 = {0, 2, 2};
        System.out.println(solution.solution(B1, M1)); // Output: 3

        // Example 2
        int M2 = 10;
        int[] B2 = {0, 3, 5, 6};
        System.out.println(solution.solution(B2, M2)); // Output: 4

        // Example 3
        int M3 = 105;
        int[] B3 = {0, 0};
        System.out.println(solution.solution(B3, M3)); // Output: 49965
    }
}

//In this solution, we use dynamic programming to calculate the number of ways to choose the previous element for each element in B.
//        The count array keeps track of how many times each element has appeared before the current index, and dp array stores the count of valid choices for each element.
//        We multiply the current count by the previous count to get the total count of valid arrays.
//        Finally, we return the count for the last element in the array. The calculations are done modulo 1_000_000_007 to avoid overflow.