package lesson6.Easy;

//Write a function
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers, returns the number of distinct values in array A.
//
//        For example, given array A consisting of six elements such that:
//
//        A[0] = 2    A[1] = 1    A[2] = 1
//        A[3] = 2    A[4] = 3    A[5] = 1
//        the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..100,000];
//        each element of array A is an integer within the range [−1,000,000..1,000,000].

//To find the number of distinct values in an array,
// you can use a HashSet to keep track of unique values as you iterate through the array. Here's a Java implementation:

import lesson5.Easy.PassingCarsEfficient;

import java.util.HashSet;
public class Distinct {
    public int solution(int[] A) {
        HashSet<Integer> distinctValues = new HashSet<>();

        for (int value : A) {
            distinctValues.add(value);
        }

        return distinctValues.size();
    }

    public static void main(String[] args) {
        Distinct solution = new Distinct();
        int [] A = {2, 1, 1, 2, 3, 1};

        System.out.println(solution.solution(A));
    }
}
//    This solution has a time complexity of O(N), where N is the length of the array.
//    The HashSet allows for constant-time average complexity for insertion and lookup operations.
//        The space complexity is also O(N) in the worst case if all elements are distinct, but it can be less in practice.