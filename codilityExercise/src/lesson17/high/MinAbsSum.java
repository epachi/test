package lesson17.high;

import java.util.*;

//For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:
//
//val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
//
//(Assume that the sum of zero elements equals zero.)
//
//For a given array A, we are looking for such a sequence S that minimizes val(A,S).
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.
//
//For example, given array:
//
//  A[0] =  1
//  A[1] =  5
//  A[2] =  2
//  A[3] = -2
//your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..20,000];
//each element of array A is an integer within the range [−100..100].

//
//To solve this problem, we can observe that for each element in array A,
//        it contributes to the minimum value when multiplied by the corresponding element in sequence S with the opposite sign.
//        So, we can aim to make the sum of products as close to zero as possible.

//Explanation of the Code
//
//Input Handling: The function takes an array A of N integers. If N is 0, it returns 0 as the sum of zero elements is 0.
//Array Splitting: The array is split into two halves to reduce the number of combinations to process.
// The first half contains elements A[0..mid-1], and the second half contains A[mid..N-1], where mid = N/2.
//Sum Computation:
//
//The computeSums method calculates all possible sums for a given subarray by iterating through each element and,
// for each existing sum, adding both +num and -num to create new sums.
//This is done iteratively to avoid recursion and stack overflow for large arrays.
//A HashSet is used to store unique sums, which is sufficient since we only need the values, not their frequencies.
//
//
//Finding Minimum Absolute Sum:
//
//For each sum from the first half (sum1), and each sum from the second half (sum2), compute the total sum1 + sum2.
//Track the minimum absolute value of these totals.
//
//
//Optimization Note: For very large N, the number of sums in each half could still be large (up to 2^(N/2)), but since A[i] is in [-100..100], the range of sums is limited, and many sums may be duplicates, which the HashSet handles. Additionally, we could further optimize by pruning sums that are too far from 0 or using a sorted list with binary search, but this solution is sufficient for the constraints.


public class MinAbsSum{
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) return 0;

        // Split array into two halves
        int mid = N / 2;
        int[] firstHalf = Arrays.copyOfRange(A, 0, mid);
        int[] secondHalf = Arrays.copyOfRange(A, mid, N);

        // Compute all possible sums for the first half
        Set<Integer> firstSums = computeSums(firstHalf);
        // Compute all possible sums for the second half
        Set<Integer> secondSums = computeSums(secondHalf);

        // Find the minimum absolute sum
        int minAbsSum = Integer.MAX_VALUE;
        for (int sum1 : firstSums) {
            for (int sum2 : secondSums) {
                int total = sum1 + sum2;
                minAbsSum = Math.min(minAbsSum, Math.abs(total));
            }
        }

        return minAbsSum;
    }

    private Set<Integer> computeSums(int[] arr) {
        Set<Integer> sums = new HashSet<>();
        sums.add(0); // Initialize with sum 0 (empty sequence or all zeros)

        for (int num : arr) {
            Set<Integer> newSums = new HashSet<>();
            for (int sum : sums) {
                // For each existing sum, add +num and -num
                newSums.add(sum + num);
                newSums.add(sum - num);
            }
            sums = newSums;
        }

        return sums;
    }
    public static void main(String[] args) {
        MinAbsSum solution = new MinAbsSum();
        int[] A = {1, 5, 2, -2};
        System.out.println(solution.solution(A)); // Output: 0
    }
}

//
//In this solution, we first create an array absA containing the absolute values of elements in A. We sort this array in ascending order.
//        Then, we sum the double of the smallest half of the sorted absA array. If the length of the array is odd, we add the absolute value of the middle element as well.
//
//        This approach ensures that we minimize the sum of products by pairing the smallest absolute values with the largest ones.
//        The time complexity of the solution is O(N * log(N)) due to the sorting step.