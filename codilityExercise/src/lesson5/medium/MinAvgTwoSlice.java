package lesson5.medium;
//A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A
// (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q]
// divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
//
//For example, array A such that:
//
//    A[0] = 4
//    A[1] = 2
//    A[2] = 2
//    A[3] = 5
//    A[4] = 1
//    A[5] = 5
//    A[6] = 8
//contains the following example slices:
//
//slice (1, 2), whose average is (2 + 2) / 2 = 2;
//slice (3, 4), whose average is (5 + 1) / 2 = 3;
//slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
//The goal is to find the starting position of a slice whose average is minimal.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average.
// If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
//
//For example, given array A such that:
//
//    A[0] = 4
//    A[1] = 2
//    A[2] = 2
//    A[3] = 5
//    A[4] = 1
//    A[5] = 5
//    A[6] = 8
//the function should return 1, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [2..100,000];
//each element of array A is an integer within the range [−10,000..10,000].

import lesson5.Easy.PassingCarsEfficient;

//
//To solve this problem, you can iterate through the array and consider slices of size 2 and 3.
//        The minimal average slice must be of size 2 or 3, as any larger slice can be split into smaller slices with lower average.
public class MinAvgTwoSlice {
    public int solution(int[] A) {
        int minAvgIndex = 0;
        double minAvg = (A[0] + A[1]) / 2.0; // Initialize with the average of the first two elements

        for (int i = 2; i < A.length; i++) {
            // Check the average of the current 2-element slice
            double avg2 = (A[i - 1] + A[i]) / 2.0;
            if (avg2 < minAvg) {
                minAvg = avg2;
                minAvgIndex = i - 1;
            }

            // Check the average of the current 3-element slice
            double avg3 = (A[i - 2] + A[i - 1] + A[i]) / 3.0;
            if (avg3 < minAvg) {
                minAvg = avg3;
                minAvgIndex = i - 2;
            }
        }

        return minAvgIndex;
    }

    public static void main(String[] args) {
        MinAvgTwoSlice solution = new MinAvgTwoSlice();
        int [] A = {4, 2, 2, 5, 1, 5, 8};
        System.out.println(solution.solution(A));
    }
}

//This solution has a time complexity of O(N), where N is the length of the input array. '
// The space complexity is O(1) since it uses a constant amount of extra space regardless of the input size.