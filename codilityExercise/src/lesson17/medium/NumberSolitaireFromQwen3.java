package lesson17.medium;

//A game for one player is played on a board consisting of N consecutive squares, numbered from 0 to N − 1.
// There is a number written on each square.
// A non-empty array A of N integers contains the numbers written on the squares.
// Moreover, some squares can be marked during the game.
//
//At the beginning of the game, there is a pebble on square number 0 and this is the only square on the board which is marked.
// The goal of the game is to move the pebble to square number N − 1.
//
//During each turn we throw a six-sided die, with numbers from 1 to 6 on its faces,
// and consider the number K, which shows on the upper face after the die comes to rest.
// Then we move the pebble standing on square number I to square number I + K,
// providing that square number I + K exists. If square number I + K does not exist,
// we throw the die again until we obtain a valid move. Finally, we mark square number I + K.
//
//After the game finishes (when the pebble is standing on square number N − 1), we calculate the result.
// The result of the game is the sum of the numbers written on all marked squares.
//
//For example, given the following array:
//
//    A[0] = 1
//    A[1] = -2
//    A[2] = 0
//    A[3] = 9
//    A[4] = -1
//    A[5] = -2
//one possible game could be as follows:
//
//the pebble is on square number 0, which is marked;
//we throw 3; the pebble moves from square number 0 to square number 3; we mark square number 3;
//we throw 5; the pebble does not move, since there is no square number 8 on the board;
//we throw 2; the pebble moves to square number 5; we mark this square and the game ends.
//The marked squares are 0, 3 and 5, so the result of the game is 1 + 9 + (−2) = 8. This is the maximal possible result that can be achieved on this board.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A of N integers, returns the maximal result that can be achieved on the board represented by array A.
//
//For example, given the array
//
//    A[0] = 1
//    A[1] = -2
//    A[2] = 0
//    A[3] = 9
//    A[4] = -1
//    A[5] = -2
//the function should return 8, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [2..100,000];
//each element of array A is an integer within the range [−10,000..10,000].

//To solve this problem, we can use dynamic programming to keep track of the maximum possible sums at each position on the board.
// We iterate through the array, and for each position,
// we calculate the maximum sum that can be achieved by considering all possible dice throws from the previous marked positions.

//✅ Example Walkthrough
//Given:
//
//java
//
//
//1
//        2
//A = [1, -2, 0, 9, -1, -2]
//        0   1  2  3   4   5
//Initialize:
//
//java
//
//
//1
//dp[0] = 1
//Compute:
//
//i=1: from 0 → dp[1] = A[1] + dp[0] = -2 + 1 = -1
//i=2: from 1 or 0 → max(dp[1], dp[0]) = max(-1,1) = 1 → dp[2] = 0 + 1 = 1
//i=3: from 2,1,0 → max(dp[2], dp[1], dp[0]) = max(1,-1,1) = 1 → dp[3] = 9 + 1 = 10
//i=4: from 3,2,1 → max(10,1,-1) = 10 → dp[4] = -1 + 10 = 9
//i=5: from 4,3,2 → max(9,10,1) = 10 → dp[5] = -2 + 10 = 8
//        ✅ Return dp[5] = 8


public class NumberSolitaireFromQwen3 {
    public int solution(int[] A) {
        int N = A.length;

        // dp[i] = max sum to reach square i
        int[] dp = new int[N];
        dp[0] = A[0];  // starting point

        for (int i = 1; i < N; i++) {
            int maxPrev = Integer.MIN_VALUE;

            // Look back at most 6 steps
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    if (dp[i - j] > maxPrev) {
                        maxPrev = dp[i - j];
                    }
                }
            }

            // If no valid previous square, skip (but should not happen in valid input)
            dp[i] = A[i] + maxPrev;
        }

        return dp[N - 1];
    }


    public static void main(String[] args) {
        NumberSolitaireFromQwen3 solution = new NumberSolitaireFromQwen3();
        int[] A = {1, -2, 0, 9, -1, -2};
        System.out.println(solution.solution(A)); // Output: 8
    }
}


//This solution has a time complexity of O(N) and uses dynamic programming to efficiently calculate the maximum sums.
// The maxSums array keeps track of the maximum sum achievable at each position.
// The outer loop iterates through the array, and the inner loop considers all possible dice throws from the previous marked positions.