package lesson17Old.medium;

//
//To further optimize the solution, we can use a sliding window approach.
//        Instead of considering all possible dice throws from the previous marked positions in each iteration,
//        we can maintain a sum of the last six marked positions.
//        This avoids recalculating sums for positions outside the window in each iteration.
public class NumberSolitaireEfficient {
    public int solution(int[] A) {
        int N = A.length;
        int[] maxSums = new int[N];

        for (int i = 1; i < N; i++) {
            maxSums[i] = Integer.MIN_VALUE;

            // Maintain a sum of the last six marked positions
            int sum = 0;
            for (int j = 1; j <= 6 && i - j >= 0; j++) {
                sum += A[i - j];
                maxSums[i] = Math.max(maxSums[i], maxSums[i - j] + sum);
            }
        }

        return maxSums[N - 1];
    }

    public static void main(String[] args) {
        NumberSolitaireEfficient solution = new NumberSolitaireEfficient();
        int[] A = {1, -2, 0, 9, -1, -2};
        System.out.println(solution.solution(A)); // Output: 8
    }
}

//By maintaining the sum of the last six marked positions, we reduce the time complexity of the inner loop to O(1),
// resulting in an overall improvement in performance. The time complexity of the solution remains O(N).