package lesson6.Easy;

//A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
//
//For example, array A such that:
//
//  A[0] = -3
//  A[1] = 1
//  A[2] = 2
//  A[3] = -2
//  A[4] = 5
//  A[5] = 6
//contains the following example triplets:
//
//(0, 1, 2), product is −3 * 1 * 2 = −6
//(1, 2, 4), product is 1 * 2 * 5 = 10
//(2, 4, 5), product is 2 * 5 * 6 = 60
//Your goal is to find the maximal product of any triplet.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A, returns the value of the maximal product of any triplet.
//
//For example, given array A such that:
//
//  A[0] = -3
//  A[1] = 1
//  A[2] = 2
//  A[3] = -2
//  A[4] = 5
//  A[5] = 6
//the function should return 60, as the product of triplet (2, 4, 5) is maximal.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [3..100,000];
//each element of array A is an integer within the range [−1,000..1,000].

import java.util.Arrays;

public class MaxProductOfThree {
    public int solution(int[] A) {
        int N = A.length;

        Arrays.sort(A);

        // The maximal product can be either the product of three largest numbers
        // or the product of two smallest numbers (if they are negative) and the largest number
        int product1 = A[N - 1] * A[N - 2] * A[N - 3];
        int product2 = A[0] * A[1] * A[N - 1];

        return Math.max(product1, product2);
    }
}

//This solution sorts the array in ascending order and then calculates the two possible products mentioned above.
// The maximum of these two products is the desired result.
//
//The time complexity of this solution is O(N log N) due to the sorting operation. Sorting is the most time-consuming part of the algorithm.
// The space complexity is O(1) as it uses a constant amount of extra space regardless of the input size.