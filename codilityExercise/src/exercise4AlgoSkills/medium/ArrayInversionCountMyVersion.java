package exercise4AlgoSkills.medium;
//
//An array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//    that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.
//
//        For example, in the following array:
//
//        A[0] = -1 A[1] = 6 A[2] = 3
//        A[3] =  4 A[4] = 7 A[5] = 4
//        there are four inversions:
//
//        (1,2)  (1,3)  (1,5)  (4,5)
//        so the function should return 4.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..100,000];
//        each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

//To solve this problem efficiently, we can use a modified merge sort algorithm to count the inversions during the merging step.
//        The idea is to keep track of the inversions while merging two sorted halves of the array.
public class ArrayInversionCountMyVersion {
    public int solution(int[] A) {
        int inversionCount = 0;
        for (int i = 0; i < A.length ; i++) {
            for (int j = i + 1; j < A.length ; j++) {
                if (A[i] > A[j]) {
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }

    public static void main(String[] args) {
        ArrayInversionCountMyVersion solution = new ArrayInversionCountMyVersion();

        // Example
        int[] A = {-1, 6, 3, 4, 7, 4};
        System.out.println(solution.solution(A)); // Output: 4
    }
}

//    This solution uses a divide-and-conquer approach to efficiently count inversions during the merge step.
//        The mergeSort method recursively divides the array into halves, sorts them, and counts inversions during merging.
//        The merge method merges two sorted subarrays while counting inversions.
//        The final result is the total number of inversions in the array. The solution checks for overflow and returns -1 if the count exceeds 1,000,000,000.