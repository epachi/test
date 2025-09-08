package codilityQ5;

//Write a Java function:
//        int solution (int [] A);
//        that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//        Given A = [1, 2, 3], the function should return 4.
//        Given A = [-1, -3], the function should return 1.
//        Write an efficient algorithm for the following assumptions:
//        N is an integer within the range [1..100,000];
//        each element of array A is an integer within the range [-1,000,000..1,000,000].
//
//
//        Certainly! The problem you've described is commonly known as the "Smallest Positive Integer Not Occurring" problem.
//        Here's a Java function that efficiently solves this problem:

import java.util.HashSet;

public class SmallestPositiveInteger {

    public static void main(String[] args) {
        int[] A1 = {1, 3, 6, 4, 1, 2};
        int result1 = solution(A1);
        System.out.println("Smallest positive integer: " + result1);

        int[] A2 = {1, 2, 3};
        int result2 = solution(A2);
        System.out.println("Smallest positive integer: " + result2);

        int[] A3 = {-1, -3};
        int result3 = solution(A3);
        System.out.println("Smallest positive integer: " + result3);
    }

    public static int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        // Populate the set with positive integers from the array
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Find the smallest positive integer not present in the set
        int smallestPositive = 1;
        while (set.contains(smallestPositive)) {
            smallestPositive++;
        }

        return smallestPositive;
    }
}