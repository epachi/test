package codilityQ6;

//A non-empty array A consisting of N integers is given.
//        A permutation is a sequence containing each element from 1 to N once, and only once.
//        For example, array A such that:
//        A[0] = 4
//        A[1] = 1
//        A[2] = 3
//        A[3] = 2
//        is a permutation, but array A such that:
//        A[0] = 4
//        A[1] = 1
//        A[2] = 3
//        is not a permutation, because value 2 is missing.
//        The goal is to check whether array A is a permutation.
//        Write a Java function:
//        int solution (int [] A);
//        that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
//        For example, given array A such that:
//        A[0] = 4
//        A[1] = 1
//        A[2] = 3
//        A[3] = 2
//        the function should return 1.
//
//        ﻿Given array A such that:
//        A[0] = 4
//        A[1] = 1
//        A[2] = 3
//        the function should return 0.
//        Write an efficient algorithm for the following assumptions:
//        - N is an integer within the range [1..100,000];
//        each element of array A is an integer within the range [1..1,000,000,000].
//
//
//        Certainly! You can solve this problem efficiently by using a HashSet to keep track of the elements encountered while iterating through the array.
//        Here's a Java function that checks whether array A is a permutation:

import java.util.HashSet;

public class PermutationCheck {

    public static void main(String[] args) {
        int[] A1 = {4, 1, 3, 2};
        int result1 = solution(A1);
        System.out.println("Is array a permutation? " + result1);

        int[] A2 = {4, 1, 3};
        int result2 = solution(A2);
        System.out.println("Is array a permutation? " + result2);
    }

    public static int solution(int[] A) {
        int N = A.length;

        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array and add elements to the set
        for (int num : A) {
            if (num > N || num <= 0 || !set.add(num)) {
                return 0; // Element is out of range or duplicated
            }
        }

        // Check if the set contains all elements from 1 to N
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                return 0; // Element is missing
            }
        }

        return 1; // Array is a permutation
    }
}

//    This solution first checks whether each element in the array is within the valid range and not duplicated.
//        Then, it verifies if the set contains all the numbers from 1 to N.
//        If any of these conditions fail, the function returns 0; otherwise, it returns 1.
//The time complexity of this solution is O(N), and the space complexity is O(N).