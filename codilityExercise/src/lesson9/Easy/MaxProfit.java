package lesson9.Easy;

//An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].
//
//For example, consider the following array A consisting of six elements such that:
//
//  A[0] = 23171
//  A[1] = 21011
//  A[2] = 21123
//  A[3] = 21366
//  A[4] = 21013
//  A[5] = 21367
//If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048.
// If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354.
// Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.
//
//Write a function,
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days,
// returns the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.
//
//For example, given array A consisting of six elements such that:
//
//  A[0] = 23171
//  A[1] = 21011
//  A[2] = 21123
//  A[3] = 21366
//  A[4] = 21013
//  A[5] = 21367
//the function should return 356, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..400,000];
//each element of array A is an integer within the range [0..200,000].

import lesson7.easy.Fish;

//To solve this problem efficiently, we can use a simple algorithm that iterates through the array and keeps track of the minimum price
// encountered so far and the maximum profit that can be obtained by selling at the current price.
// The key idea is to find the minimum price and update the maximum profit for each new price encountered.
//Also: // Ref: Lesson 45 of https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14143365#overview

public class MaxProfit {
    public int solution(int[] A) {
        if (A.length < 2) {
            return 0; // Not enough days for a transaction
        }

        int minPrice = A[0];
        int maxProfit = 0;

        for (int i = 1; i < A.length; i++) {
            minPrice = Math.min(minPrice, A[i]);
            maxProfit = Math.max(maxProfit, A[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit solution = new MaxProfit();
        int [] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution.solution(A));
    }
}
//This algorithm has a time complexity of O(N), where N is the length of the input array, as it iterates through the array once.
// The space complexity is O(1) since it uses only a constant amount of additional space.
//
//The algorithm maintains two variables: minPrice to keep track of the minimum price encountered so far and maxProfit to keep track
// of the maximum profit that can be obtained by selling at the current price.
// It updates these variables while iterating through the array, resulting in the maximum possible profit from one transaction