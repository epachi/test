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


/// ////////////////////////////////////////////
//Solution Approach
//Dynamic Programming (DP):
//The problem resembles a maximum sum problem with constraints on placement, making DP a suitable approach.
//We need to decide whether to place a tile at each possible index and track the number of tiles used.
//Define a DP state: dp[i][k], where:
//i is the index up to which we’ve considered the array (i.e., we’re deciding whether to place a tile starting at i or later).
//k is the number of tiles used (0 to 3).
//dp[i][k] represents the maximum sum achievable using k tiles on the subarray starting from index i.
//        Recurrence:
//For each index i, we have two choices:
//Skip index i and move to i+1 without using a tile: dp[i][k] = dp[i+1][k].
//Place a tile at i (covering A[i] + A[i+1]) and move to i+2 with one more tile: dp[i][k] = A[i] + A[i+1] + dp[i+2][k-1] (if k > 0 and i+1 < N).
//Take the maximum of these choices.
//Base Cases:
//If i >= N, return 0 (no elements left to cover).
//If k < 0, return a large negative value (invalid, as we can’t use negative tiles).
//If i == N-1, we can’t place a tile (it would extend beyond the array), so dp[N-1][k] = 0 for k >= 0.
//Optimization:
//Since N can be up to 100,000, we need an efficient implementation.
//A recursive DP with memoization or an iterative bottom-up approach will work.
//To handle large N, we’ll use a bottom-up DP to avoid stack overflow and optimize space.
//Space Optimization:
//Since dp[i][k] depends on dp[i+1][k] and dp[i+2][k-1], we only need to store a few rows.
//We can use a 2D array of size N x 4 (since k is at most 3).
//Alternatively, since k is small, we can optimize further, but a straightforward N x 4 array is sufficient given the constraints.
//Algorithm
//Create a DP array dp where dp[i][k] stores the maximum sum using k tiles from index i onward.
//Initialize the base cases:
//For i >= N, dp[i][k] = 0.
//For k < 0, return a large negative value (e.g., Integer.MIN_VALUE).
//Iterate from i = N-1 to 0 (bottom-up):
//For each k from 0 to 3:
//Compute dp[i][k] as the maximum of:
//dp[i+1][k] (skip index i).
//A[i] + A[i+1] + dp[i+2][k-1] (place tile at i, if k > 0 and i+1 < N).
//Return dp[0][3], which gives the maximum sum using up to 3 tiles starting from index 0.
//Time and Space Complexity
//Time Complexity: O(N * K), where N is the array length and K = 4 (since k ranges from 0 to 3). For each i and k, we perform constant-time operations. Since K is fixed at 4, this is effectively O(N).
//Space Complexity: O(N * K) for the DP array, which is O(N) since K = 4. We can optimize to O(1) space by only keeping the last two rows (i+1 and i+2), but the standard O(N) approach is simpler and sufficient given the constraints.
//Java Implementation
//Below is the Java code implementing the bottom-up DP approach. The code includes boundary checks and handles all the example cases correctly.
//
//Solution.java
//x-java
//Edit in files
//•
//Show inline
//Explanation of the Code
//DP Array: We use a long[][] array to avoid integer overflow, as each element in A can be up to 1,000,000, and the sum of three tiles could theoretically approach 3 * 2 * 1,000,000 = 6,000,000, which fits in an int but may temporarily need long during computation.
//        Initialization: We set dp[N][k] = 0 and dp[N+1][k] = 0 for all k to handle cases where i+1 or i+2 goes beyond the array.
//DP Loop:
//Iterate i from N-1 to 0 to fill the table bottom-up.
//For each k from 0 to 3:
//Compute the “skip” case: dp[i][k] = dp[i+1][k].
//If k > 0 and i+1 < N, compute the “place tile” case: A[i] + A[i+1] + dp[i+2][k-1].
//Take the maximum of the two.
//Boundary Checks: We ensure i+1 < N before accessing A[i+1] and only place a tile if k > 0.
//Final Answer: dp[0][3] gives the maximum sum using up to 3 tiles starting from index 0. We cast to int as the final result fits within the integer range.
//Handling Example Cases
//A = [2, 3, 5, 2, 3, 4, 6, 4, 1]:
//Tiles at indices 1 (3+5=8), 4 (3+4=7), 6 (6+4=10) give 8 + 7 + 10 = 25.
//The DP computes all possible placements and selects this as the maximum.
//        A = [1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1]:
//Tiles at 1 (5+3=8), 4 (6+10=16), 7 (4+7=11) give 8 + 16 + 11 = 35.
//The algorithm evaluates all valid combinations and returns 35.
//A = [1, 2, 3, 3, 2]:
//Tiles at 1 (2+3=5), 3 (3+2=5) give 5 + 5 = 10.
//Only two tiles fit, and k=3 considers cases with fewer tiles, returning 10.
//A = [5, 10, 3]:
//Tile at 0 (5+10=15) gives 15.
//Only one tile fits, and the algorithm correctly returns 15.
//Edge Cases Handled
//        N = 2: Only one tile is possible (e.g., [5, 10] gives 15).
//N = 3: Only one tile fits (e.g., [5, 10, 3] gives 15).
//N = 4: Up to two tiles (e.g., [1, 2, 3, 4] gives 2+3=5 or 3+4=7, max is 7).
//Empty or invalid cases: Not applicable since N >= 2.
//Large values: Using long for intermediate sums prevents overflow.
//This solution is efficient (O(N) time, O(N) space) and handles all constraints and example cases correctly.

public class Question3_Grok2 {
    public int solution(int[] A) {
        int N = A.length;
        // dp[i][k] = max sum using k tiles from index i onward
        long[][] dp = new long[N + 2][4];

        // Base case: for i >= N, no elements to cover, sum is 0
        for (int k = 0; k <= 3; k++) {
            dp[N][k] = 0;
            dp[N + 1][k] = 0;
        }

        // Fill DP table from right to left
        for (int i = N - 1; i >= 0; i--) {
            for (int k = 0; k <= 3; k++) {
                // Option 1: Skip current index
                dp[i][k] = dp[i + 1][k];

                // Option 2: Place a tile at index i (if possible)
                if (k > 0 && i + 1 < N) {
                    dp[i][k] = Math.max(dp[i][k], (long)A[i] + A[i + 1] + dp[i + 2][k - 1]);
                }
            }
        }

        // Return max sum using up to 3 tiles starting from index 0
        return (int)dp[0][3];
    }


    // Test method to verify the solution
    public static void main(String[] args) {
        Question3_Grok2 sol = new Question3_Grok2();

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