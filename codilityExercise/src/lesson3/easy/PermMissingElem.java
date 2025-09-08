package lesson3.easy;

//An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
//
//Your goal is to find that missing element.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A, returns the value of the missing element.
//
//For example, given array A such that:
//
//  A[0] = 2
//  A[1] = 3
//  A[2] = 1
//  A[3] = 5
//the function should return 4, as it is the missing element.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..100,000];
//the elements of A are all distinct;
//each element of array A is an integer within the range [1..(N + 1)].

//You can solve this problem by calculating the expected sum of the elements in the range [1, N+1]
// and then subtracting the sum of the elements in the array.
// The result will be the missing element. Here's a Java implementation:
public class PermMissingElem {
    public int solution(int[] A) {
        int N = A.length;
        // Calculate the expected sum of the elements in [1, N+1]
        int expectedSum = (N + 1) * (N + 2) / 2;

        // Calculate the sum of the elements in the array
        int actualSum = 0;
        for (int num : A) {
            actualSum += num;
        }

        // Return the missing element
        return expectedSum - actualSum;
    }
}

//This solution has a time complexity of O(N) and a space complexity of O(1).