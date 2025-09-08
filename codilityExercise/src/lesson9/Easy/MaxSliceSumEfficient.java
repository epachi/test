package lesson9.Easy;

//The Kadane's algorithm provided is already an efficient solution for finding the maximum sum of any slice in an array with a time complexity of O(N),
// where N is the length of the input array. This algorithm is well-optimized for this specific problem.
//
//If you're looking for further optimization, consider the fact that the maximum sum of a slice
// is either the sum of a non-empty slice or zero.
// You can modify the algorithm slightly to return zero when all elements in the array are negative,
// as including any negative element will always reduce the sum. Here's the modified implementation
public class MaxSliceSumEfficient {
    public int solution(int[] A) {
        int maxEndingHere = 0;
        int maxSoFar = 0;

        // Flag to check if all elements are negative
        boolean allNegative = true;

        for (int a : A) {
            if (a >= 0) {
                allNegative = false;
                break;
            }
        }

        // If all elements are negative, return zero
        if (allNegative) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
//This modification adds a check for all-negative elements at the beginning of the loop,
// and if all elements are negative, it directly returns zero. This avoids unnecessary calculations when there are no positive elements in the array.
//
//Keep in mind that further optimization might be unnecessary or result in only marginal improvements.
// The provided Kadane's algorithm is already quite efficient for this problem.