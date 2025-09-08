package codilityQ7;
//A non-empty array A consisting of N integers is given. The product of
//        triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P<Q<R<N).
//        For example, array A such that:
//        A[0] = -3
//        A[1] = 1
//        A[2] = 2
//        A[3] = -2
//        A[4] = 5
//        A[5] = 6
//        contains the following example triplets:
//        - (0, 1, 2), product is -3*1*2=-6
//        - (1, 2, 4), product is 1*2*5=10
//        - (2, 4, 5), product is 2*5*6 = 60
//        Your goal is to find the maximal product of any triplet.
//        Write a Java function:
//        int solution (int [] A);
//        that, given a non-empty array A, returns the value of the maximal product of any triplet.
//        For example, given array A such that:
//        A[0] = -3
//        A[1] = 1
//        A[2] = 2
//        A[3] = -2
//        A[4] = 5
//        A[5] = 6
//        the function should return 60, as the product of triplet (2, 4, 5) is maximal.
//
//        ﻿Write an efficient algorithm for the following assumptions:
//        - N is an interier within the range [3..100,000];
//        - each element of array A is an integer within the range [-1,000..1,000].
//
//
//
//        Certainly! You can find the maximal product of any triplet by considering both positive and negative values in the array.
//        The key is to identify the two smallest and three largest values, as the product of the three largest values or the two smallest
//        (which may include negative numbers)
//        and the largest value will result in the maximal product. Here's a Java function to achieve this:

import java.util.Arrays;

public class MaxTripletProduct {

    public static void main(String[] args) {
//        int[] A = {-3, 1, 2, -2, 5, 6};
        int [] A = {-1, -2,  5, 6};
        int result = solution(A);
        System.out.println("Maximal product of any triplet: " + result);
    }

    public static int solution(int[] A) {
        int N = A.length;

        // Sort the array to easily identify the two smallest and three largest values
        Arrays.sort(A);                                             //<=== Arrays.sort(A)

        // Calculate two possible maximal products:
        // 1. Product of three largest values
        // 2. Product of two smallest values (potentially negative) and the largest value
        int product1 = A[N - 1] * A[N - 2] * A[N - 3];
        int product2 = A[0] * A[1] * A[N - 1];

        // Return the maximum of the two products
        return Math.max(product1, product2);
    }
}
//    This solution first sorts the array in ascending order. It then calculates the maximal product of the
//    three largest values and the product of the two smallest
//    values and the largest value. Finally, it returns the maximum of these two products.
//
//        The time complexity of this solution is O(N log N) due to the sorting operation.
//        The space complexity is O(1) as we use only a constant amount of extra space.