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

public class Question3_Claude {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 2) return 0;

        // dp[i][j] = maximum sum using at most j tiles considering elements 0..i
        int[][] dp = new int[N][4]; // 0 to 3 tiles

        // Initialize first position - no tiles can be placed
        for (int tiles = 0; tiles <= 3; tiles++) {
            dp[0][tiles] = 0;
        }

        // Fill the DP table
        for (int i = 1; i < N; i++) {
            for (int tiles = 0; tiles <= 3; tiles++) {
                // Option 1: Don't place a tile at position i
                dp[i][tiles] = dp[i-1][tiles];

                // Option 2: Place a tile covering positions i-1 and i
                if (tiles > 0) {
                    int tileSum = A[i-1] + A[i];
                    if (i >= 2) {
                        // If we can place a tile, add it to the best result from i-2
                        dp[i][tiles] = Math.max(dp[i][tiles], dp[i-2][tiles-1] + tileSum);
                    } else {
                        // i == 1, this is the first possible tile placement
                        dp[i][tiles] = Math.max(dp[i][tiles], tileSum);
                    }
                }
            }
        }

        return dp[N-1][3];
    }

    // Test method to verify the solution
    public static void main(String[] args) {
        Question3_Claude sol = new Question3_Claude();

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