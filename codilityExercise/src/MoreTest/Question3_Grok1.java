package MoreTest;

//There is an array A of N integers and three tiles. Each tile can cover two neighbouring numbers
//from the array but cannot intersect with another tile.
//It also cannot be placed outside the array, even partially.
//
//Write a Java function:
//class Solution { public int solition (int[] A); }
//that, given an array A of N integers, returns the maximum sum of numbers that can be covered using at most three tiles.
//
//        Examples:
//        1. Given A = [2, 3, 5, 2, 3, 4, 6, 4, 1], the function should return 25.
//There is only one optimal placement of tiles: (3,5), (3,4), (6,4).
//        2. Given A = [1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1], the function should return 35.
//One of the three optimal placements of tiles is (5, 3), (6, 10), (4,7).
//        3. Given A = [1, 2, 3, 3, 2], the function should return 10. There is one optimal placement of tiles: (2,3), (3, 2).
//Only two tiles can be used because A is too small to contain another one.
//4. Given A = [5, 10, 3], the function should return 15. Only one tile can be used.
//Write an efficient algorithm for the following assumptions:
//        - N is an integer within the range [2..100,000);
//        - each element of array A is an integer within the range [0..1,000,000].

public class Question3_Grok1 {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 2) return 0; // Edge case: array too small

        // Array P: sum of each pair
        int[] P = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            P[i] = A[i] + A[i + 1];
        }

        // DP[i][k]: max sum using exactly k pairs from P[0] to P[i-1]
        long[][] dp = new long[N][4]; // Use long to avoid integer overflow
        // Initialize first row
        dp[0][0] = 0;
        for (int k = 1; k <= 3; k++) {
            dp[0][k] = Long.MIN_VALUE / 2; // Negative infinity equivalent
        }

        // Fill DP table
        for (int i = 1; i <= N - 1; i++) {
            dp[i][0] = dp[i - 1][0]; // No pairs used
            for (int k = 1; k <= 3; k++) {
                // Max of: (1) not using P[i-1], (2) using P[i-1] with k-1 pairs
                dp[i][k] = dp[i - 1][k];
                if (i >= 2 && dp[i - 2][k - 1] != Long.MIN_VALUE / 2) {
                    dp[i][k] = Math.max(dp[i][k], dp[i - 2][k - 1] + P[i - 1]);
                } else if (i == 1 && k == 1) {
                    dp[i][k] = P[0]; // Only one pair available
                }
            }
        }

        // Find maximum sum with at most 3 tiles
        long maxSum = dp[N - 1][0];
        for (int k = 1; k <= 3; k++) {
            maxSum = Math.max(maxSum, dp[N - 1][k]);
        }

        return (int) maxSum;
    }


    // Test method to verify the solution
    public static void main(String[] args) {
        Question3_Grok1 sol = new Question3_Grok1();

        // Test case 1: [2, 3, 5, 2, 3, 4, 6, 4, 1] should return 25
        int[] test1 = {2, 3, 5, 2, 3, 4, 6, 4, 1};
        System.out.println("Test 1: " + sol.solution(test1)); // Expected: 25

        // Test case 2: [1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1] should return 35
        int[] test2 = {1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1};
        System.out.println("Test 2: " + sol.solution(test2)); // Expected: 35

        // Test case 3: [1, 2, 3, 3, 2] should return 10
        int[] test3 = {1, 2, 3, 3, 2};
        System.out.println("Test 3: " + sol.solution(test3)); // Expected: 10

        // Test case 4: [5, 10, 3] should return 15
        int[] test4 = {5, 10, 3};
        System.out.println("Test 4: " + sol.solution(test4)); // Expected: 15

        // Additional test cases
        int[] test5 = {1, 2}; // Only one tile possible
        System.out.println("Test 5: " + sol.solution(test5)); // Expected: 3

        int[] test6 = {10, 1, 10, 1, 10}; // Test alternating pattern
        System.out.println("Test 6: " + sol.solution(test6)); // Expected: 22 (10+1, 1+10)
    }
}