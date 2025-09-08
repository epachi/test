package codilityQ4;
public class TapeEquilibriumEfficient {

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3};
        int result = solution(A);
        System.out.println("Minimal difference: " + result);
    }

    public static int solution(int[] A) {
        int N = A.length;

        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int leftSum = 0;
        int rightSum = totalSum;
        int minimalDifference = Integer.MAX_VALUE;

        // Iterate through each possible split point P
        for (int P = 1; P < N; P++) {
            leftSum += A[P - 1];
            rightSum -= A[P - 1];

            // Calculate the absolute difference for the current split point
            int currentDifference = Math.abs(leftSum - rightSum);                   //<===== Math.abs

            // Update the minimal difference
            minimalDifference = Math.min(minimalDifference, currentDifference);
        }

        return minimalDifference;
    }
}

//
//    This solution maintains the efficiency of the original solution, and it is already quite optimized for this problem.
//        The time complexity remains O(N), and the space complexity is O(1).
//        The key improvement here is to calculate the total sum of the array only once and then update the left and right sums while iterating through the array.
//

