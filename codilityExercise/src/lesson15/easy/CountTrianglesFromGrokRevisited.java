package lesson15.easy;

import java.util.Arrays;

//An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R]. In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
//
//A[P] + A[Q] > A[R],
//A[Q] + A[R] > A[P],
//A[R] + A[P] > A[Q].
//For example, consider array A such that:
//
//  A[0] = 10    A[1] = 2    A[2] = 5
//  A[3] = 1     A[4] = 8    A[5] = 12
//There are four triangular triplets that can be constructed from elements of this array, namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers, returns the number of triangular triplets in this array.
//
//For example, given array A such that:
//
//  A[0] = 10    A[1] = 2    A[2] = 5
//  A[3] = 1     A[4] = 8    A[5] = 12
//the function should return 4, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..1,000];
//each element of array A is an integer within the range [1..1,000,000,000].
public class CountTrianglesFromGrokRevisited {
    public int solution(int[] A) {
        int n = A.length;
        int count = 0;

        // Sort the array to simplify triangle inequality checks
        Arrays.sort(A);

        // Iterate through all possible triplets (P, Q, R) where P < Q < R
        for (int P = 0; P < n - 2; P++) {
            int R = P + 2; // Start R at P + 2 as it must be greater than Q
            for (int Q = P + 1; Q < n - 1; Q++) {
                // Find the largest R for which A[P] + A[Q] > A[R]
                while (R < n && A[P] + A[Q] > A[R]) {
                    R++;
                }
                // All indices from Q + 1 to R - 1 form valid triangular triplets with P and Q
                count += R - Q - 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountTrianglesFromGrokRevisited solution = new CountTrianglesFromGrokRevisited();

        int [] A = {10, 2, 5, 1, 8, 12};

        int numOfTriangles = solution.solution(A);

        System.out.println("numOfTriangles==>" + numOfTriangles);

    }
}

//This solution first sorts the input array.
// Then, it iterates through the array and, for each element A[i],
// it tries to find all possible triangular triplets with the condition A[P] + A[Q] > A[R].
// If this condition holds, it means that all elements from A[i+2] to the end of the array can form a triangular triplet with A[i] and A[i+1].
// The count is incremented accordingly.
//
//The time complexity of this solution is O(N*log(N)), where N is the length of array A, due to the sorting step.
// The subsequent iteration is O(N).
