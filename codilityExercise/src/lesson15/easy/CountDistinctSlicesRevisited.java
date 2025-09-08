package lesson15.easy;


import java.util.HashSet;

//An integer M and a non-empty array A consisting of N non-negative integers are given. All integers in array A are less than or equal to M.
//
//A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the elements A[P], A[P + 1], ..., A[Q].
// \A distinct slice is a slice consisting of only unique numbers. That is, no individual number occurs more than once in the slice.
//
//For example, consider integer M = 6 and array A such that:
//
//    A[0] = 3
//    A[1] = 4
//    A[2] = 5
//    A[3] = 5
//    A[4] = 2
//There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).
//
//The goal is to calculate the number of distinct slices.
//
//Write a function:
//
//class Solution { public int solution(int M, int[] A); }
//
//that, given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.
//
//If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.
//
//For example, given integer M = 6 and array A such that:
//
//    A[0] = 3
//    A[1] = 4
//    A[2] = 5
//    A[3] = 5
//    A[4] = 2
//the function should return 9, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..100,000];
//M is an integer within the range [0..100,000];
//each element of array A is an integer within the range [0..M].

// To solve this problem, we can use the two-pointer technique. We can maintain two pointers, start and end,
// representing the start and end of the current slice, and a set to keep track of the distinct elements in the current slice.
// Catepillar method
public class CountDistinctSlicesRevisited {
    public int solution(int M, int[] A) {
        int distinctSlices = 0;
        int start = 0;
        int end = 0;
        HashSet<Integer> distinctSet = new HashSet<>();

        while (end < A.length) {
            if (!distinctSet.contains(A[end])) {
                distinctSet.add(A[end]);
                end++;
                distinctSlices += distinctSet.size();

                if (distinctSlices > 1_000_000_000) {
                    return 1_000_000_000;
                }
            } else {
                distinctSet.remove(A[start]);
                start++;
            }
        }

        return distinctSlices;
    }

    public static void main(String[] args) {
        CountDistinctSlicesRevisited solution = new CountDistinctSlicesRevisited();
        int M = 6;
        int [] A = {3, 4, 5, 5, 2};

        int minNumOfNails = solution.solution(M, A);

        System.out.println("minNumOfNails==>" + minNumOfNails);

    }
}


//This solution maintains a sliding window [start, end] and uses a HashSet (distinctSet) to keep track of the distinct elements in the current slice. The distinctSlices variable is incremented by the size of the distinctSet whenever a new distinct element is added.
//
//Make sure to check if distinctSlices exceeds 1,000,000,000, and return 1,000,000,000 in that case as specified in the problem statement.
//
//This solution has a time complexity of O(N) where N is the length of array A, and it uses O(M) space for the HashSet.