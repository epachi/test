package lesson4.easy;

import java.util.HashSet;

//A non-empty array A consisting of N integers is given.
//
//A permutation is a sequence containing each element from 1 to N once, and only once.
//
//For example, array A such that:
//
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    A[3] = 2
//is a permutation, but array A such that:
//
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//is not a permutation, because value 2 is missing.
//
//The goal is to check whether array A is a permutation.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
//
//For example, given array A such that:
//
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    A[3] = 2
//the function should return 1.
//
//Given array A such that:
//
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//the function should return 0.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [1..1,000,000,000].

//You can solve this problem by checking two conditions:
//
//The array should have unique elements.
//The array should contain elements from 1 to N, where N is the length of the array.

public class PermCheck {
    public int solution(int[] A) {
        int N = A.length;

        // Check condition 1: Unique elements
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int num : A) {
            if (!uniqueElements.add(num)) {
                return 0; // Duplicate element found
            }
        }

        // Check condition 2: Elements from 1 to N
        for (int i = 1; i <= N; i++) {
            if (!uniqueElements.contains(i)) {
                return 0; // Element missing in the array
            }
        }

        return 1; // Array is a permutation
    }
}
//This solution has a time complexity of O(N) and a space complexity of O(N), where N is the length of the array.
// It efficiently checks both conditions and returns the result accordingly.