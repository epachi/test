package lesson10.medium;



public class FlagsEfficient {
    public int solution(int[] A) {
        int n = A.length;

        // Find peaks
        int[] peaks = new int[n];
        int peakCount = 0;
        for (int i = 1; i < n - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[peakCount++] = i;
            }
        }

        if (peakCount == 0) {
            // No peaks, no flags can be set
            return 0;
        }

        int maxFlags = 1;

        // Try setting flags from 2 to the square root of the number of peaks
        for (int flags = 2; flags * (flags - 1) <= peakCount * 2; flags++) {
            int currentFlags = 1;
            int position = peaks[0];

            // Greedily set flags on peaks
            for (int i = 1; i < peakCount && currentFlags < flags; i++) {
                if (peaks[i] - position >= flags) {
                    currentFlags++;
                    position = peaks[i];
                }
            }

            // Update the result
            maxFlags = Math.max(maxFlags, currentFlags);
        }

        return maxFlags;
    }
}

//This solution avoids using a boolean array to mark peaks and directly stores the peak indices in the peaks array.
// It also eliminates unnecessary iterations and checks. The overall time complexity is O(N * log(log(N))) due to the prime factorization.
