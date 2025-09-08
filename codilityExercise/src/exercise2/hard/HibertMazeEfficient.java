package exercise2.hard;

//Certainly! To improve efficiency, we can use dynamic programming to avoid redundant calculations.
//        We can create a memoization table to store previously computed results for subproblems.
//        This can significantly reduce the number of recursive calls and speed up the algorithm.
public class HibertMazeEfficient {
    public int solution(int N, int A, int B, int C, int D) {
        int size = (int) Math.pow(2, N) + 1;
        int[][] memo = new int[size][size];

        return minSteps(N, A, B, C, D, memo);
    }

    private int minSteps(int N, int currentX, int currentY, int targetX, int targetY, int[][] memo) {
        if (currentX == targetX && currentY == targetY) {
            return 0;
        }

        if (memo[currentX][currentY] != 0) {
            return memo[currentX][currentY];
        }

        int size = (int) Math.pow(2, N) + 1;
        int halfSize = size / 2;

        int result = Integer.MAX_VALUE;

        if (targetX < halfSize && targetY < halfSize) {
            result = Math.min(result, minSteps(N - 1, currentX, currentY, targetX, targetY, memo));
        }

        if (targetX < halfSize && targetY >= halfSize) {
            result = Math.min(result, minSteps(N - 1, currentX, currentY - halfSize, targetX, targetY - halfSize, memo) + 1);
        }

        if (targetX >= halfSize && targetY < halfSize) {
            result = Math.min(result, minSteps(N - 1, currentX - halfSize, currentY, targetX - halfSize, targetY, memo) + 1);
        }

        if (targetX >= halfSize && targetY >= halfSize) {
            result = Math.min(result, minSteps(N - 1, currentX - halfSize, currentY - halfSize, targetX - halfSize, targetY - halfSize, memo) + 2);
        }

        result += 2 * Math.abs(currentX - targetX) + 2 * Math.abs(currentY - targetY);

        memo[currentX][currentY] = result;
        return result;
    }
}

//    This dynamic programming approach with memoization helps avoid redundant computations and can be more efficient,
//        especially for larger inputs.