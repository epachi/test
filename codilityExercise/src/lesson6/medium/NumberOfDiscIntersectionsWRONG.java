package lesson6.medium;
//We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
//
//We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).
//
//The figure below shows discs drawn for N = 6 and A as follows:
//
//  A[0] = 1
//  A[1] = 5
//  A[2] = 2
//  A[3] = 1
//  A[4] = 4
//  A[5] = 0
//
//
//There are eleven (unordered) pairs of discs that intersect, namely:
//
//discs 1 and 4 intersect, and both intersect with all the other discs;
//disc 2 also intersects with discs 0 and 3.
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs.
// The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
//
//Given array A shown above, the function should return 11, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..100,000];
//each element of array A is an integer within the range [0..2,147,483,647].

//To efficiently solve this problem, you can use the concept of counting the number of intersecting pairs.
// The idea is to use the fact that if a disc i intersects with k other discs,
// it contributes k to the total count of intersecting pairs. This avoids the need to explicitly check each pair for intersection.

import java.util.Arrays;

public class NumberOfDiscIntersectionsWRONG {
    public int solution(int[] A) {
        int N = A.length;

        // Arrays to store the starting and ending points of each disc
        long[] discStarts = new long[N];
        long[] discEnds = new long[N];

        // Populate the arrays with disc starting and ending points
        for (int i = 0; i < N; i++) {
            discStarts[i] = (long) i - A[i];
            discEnds[i] = (long) i + A[i];
        }

        // Sort the arrays of disc starting and ending points
        Arrays.sort(discStarts);
        Arrays.sort(discEnds);

        int intersectingPairs = 0;
        int activeDiscs = 0; // Number of currently active (intersecting) discs

        for (int i = 0; i < N; i++) {
            // Find the number of currently active discs ending at or before the current disc starts
            while (i < N - 1 && discStarts[i + 1] <= discEnds[i]) {
                activeDiscs++;
                i++;
            }

            // Update the count of intersecting pairs
            intersectingPairs += activeDiscs;

            // Check for the exceeding condition
            if (intersectingPairs > 10_000_000) {
                return -1;
            }

            // Decrement the count of currently active discs
            activeDiscs--;
        }

        return intersectingPairs;
    }

    public static void main(String[] args) {
        NumberOfDiscIntersectionsWRONG solution = new NumberOfDiscIntersectionsWRONG();
        int [] A = {1, 5, 2, 1, 4, 0};

        System.out.println(solution.solution(A));
    }
}
//This solution first calculates the starting and ending points for each disc and sorts these points separately.
// Then, it iterates through the discs and calculates the number of intersecting pairs efficiently.
// The algorithm has a time complexity of O(N log N) due to the sorting operation, and the space complexity is O(N).