package codilityQ8;

//An array A consisting of N integers is given.
//        A triplet (P, Q, R) is triangular if 0 ≤ P<Q<R<N and:
//        - A[P] + A[Q] > A[R],
//        - A[Q] + A[R] > A[P],
//        - A[R] + A[P] > A[Q].
//        For example, consider array A such that:
//        A[0] = 10
//        A[3] = 1
//        A[1] = 2
//        A[2] = 5
//        A[4] = 8
//        A[5] = 20
//        Triplet (0, 2, 4) is triangular.
//        Write a Java function:
//        int solution (int [] A);
//        that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
//        For example, given array A such that:
//        A[0] = 10
//        A[3] = 1
//        A[1] = 2
//        A[2] = 5
//        A[4] = 8
//        A[5] = 20
//        the function should return 1, as explained above. Given array A such that:
//        A[0] = 10
//        A[1] = 50
//        A[2] = 5
//        A[3] = 1
//        the function should return 0.
//        Write an efficient algorithm for the following assumptions:
//        ﻿N is an integer within the range [0..100,000];
//        each element of array A is an integer within the range -2,147,497,620:13,147,483,647].
//
//
//        Certainly! To check if there exists a triangular triplet in the array, we can sort the array in non-decreasing order
//        and then iterate through it to check the triangular condition for each triplet. Here's the Java function:

import java.util.Arrays;

public class TriangularTriplet {

    public static void main(String[] args) {
        int[] A1 = {10, 2, 5, 1, 8, 20};
        int result1 = solution(A1);
        System.out.println("Exists a triangular triplet? " + result1);

        int[] A2 = {10, 50, 5, 1};
        int result2 = solution(A2);
        System.out.println("Exists a triangular triplet? " + result2);
    }

    public static int solution(int[] A) {
        int N = A.length;

        // Sort the array in non-decreasing order
        Arrays.sort(A);                         //<===Arrays.sort(A)

        // Iterate through the array to check for triangular triplets
        for (int i = 0; i < N - 2; i++) {
            long P = A[i];
            long Q = A[i + 1];
            long R = A[i + 2];

            // Check the triangular condition
            if (P + Q > R && Q + R > P && R + P > Q) {
                return 1; // Triangular triplet found
            }
        }

        return 0; // No triangular triplet found
    }
}

//    This solution sorts the array in non-decreasing order using Arrays.sort(A).
//        Then, it iterates through the array to check the triangular condition for each triplet. If a triangular triplet is found,
//        the function returns 1; otherwise, it returns 0.
//
//        The time complexity of this solution is O(N log N) due to the sorting operation.
//        The space complexity is O(1) as we use only a constant amount of extra space.

