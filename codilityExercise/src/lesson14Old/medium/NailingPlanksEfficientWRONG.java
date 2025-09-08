package lesson14Old.medium;

//
//Certainly! We can further optimize the solution by using the concept of prefix sums.
//        We will create an array to represent the cumulative count of nails at each position.
//        This array will help us quickly determine the count of nails in a given range.
import java.util.Arrays;

//Use binary Search
public class NailingPlanksEfficientWRONG {
    public int solution(int[] A, int[] B, int[] C) {
        int[] sortedNails = Arrays.copyOf(C, C.length);
        Arrays.sort(sortedNails);

        int[] prefixSum = new int[2 * sortedNails.length + 1];
        Arrays.fill(prefixSum, 0);

        for (int i = 0; i < sortedNails.length; i++) {
            prefixSum[sortedNails[i]] = 1;
        }

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        int result = -1;

        for (int i = 0; i < A.length; i++) {
            int start = A[i];
            int end = B[i];

            int nailsInRange = prefixSum[end] - prefixSum[start - 1];

            if (nailsInRange == 0) {
                return -1; // Unable to nail all planks
            }

            result = Math.max(result, nailsInRange);
        }

        return result;
    }

    public static void main(String[] args) {
        NailingPlanksWRONG solution = new NailingPlanksWRONG();
        int [] A = {1, 4, 5, 8};
        int [] B = {4, 5, 9, 10};
        int [] C = {4, 6, 7, 10, 2};

        int minNumOfNails = solution.solution(A, B, C);

        System.out.println("minNumOfNails==>" + minNumOfNails);

    }
}


//This solution has a time complexity of O((N+M) + (N+M) * log(M)),
// which is more efficient than the previous solution for larger datasets.