package lesson5.medium;
// Sure, we can optimize the solution by realizing that the minimal average slice of length
// 2 or 3 must also be a prefix of a minimal average slice for a larger slice. This is known as the "prefix sum" approach.

public class MinAvgTwoSliceEfficient {
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

//    This solution has the same time complexity of O(N), but it's a bit more efficient in practice
//        since it avoids recomputing the prefix sums for the 3-element slices.
//        The space complexity remains O(1).