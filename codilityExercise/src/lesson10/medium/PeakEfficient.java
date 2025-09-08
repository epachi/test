package lesson10.medium;

//Certainly! The provided solution is already relatively efficient, but we can make some improvements to avoid redundant computations.
// Specifically, we can optimize the way we check whether a given number of blocks is valid.

public class PeakEfficient {
    public int solution(int[] A) {
        int N = A.length;

        // Find peaks
        int[] peaks = new int[N];
        int peakCount = 0;
        for (int i = 1; i < N - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks[peakCount++] = i;
            }
        }

        // If there are no peaks, return 0
        if (peakCount == 0) {
            return 0;
        }

        // Try different values of K using binary search
        int left = 1;
        int right = peakCount;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isValidDivision(A, peaks, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean isValidDivision(int[] A, int[] peaks, int K) {
        int N = A.length;
        int blocks = 0;
        int currentBlock = 0;

        for (int peak : peaks) {
            if (peak >= currentBlock * K && peak < (currentBlock + 1) * K) {
                currentBlock++;
                blocks++;

                if (blocks == K) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PeakRevisit solution = new PeakRevisit();
        int [] input = { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};

        System.out.println(solution.solution(input));

    }
}
//In this version, the isValidDivision function has been optimized to avoid unnecessary computations.
// It increments currentBlock only when a peak is found within the current block,
// and it increments blocks only when a new block is formed. This reduces the overall complexity of the algorithm.