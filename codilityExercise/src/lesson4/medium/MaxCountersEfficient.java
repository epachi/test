package lesson4.medium;

//Certainly! We can achieve better performance by avoiding unnecessary updates on individual counters and updating all counters
//        together when a "max counter" operation is encountered. '
//        This way, we only need to keep track of the last "max counter" operation and update all counters at once.
public class MaxCountersEfficient {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int lastMaxCounter = 0;

        for (int value : A) {
            if (value >= 1 && value <= N) {
                // Increase operation
                if (counters[value - 1] < lastMaxCounter) {
                    counters[value - 1] = lastMaxCounter + 1;
                } else {
                    counters[value - 1]++;
                }

                // Update maxCounter
                maxCounter = Math.max(maxCounter, counters[value - 1]);
            } else if (value == N + 1) {
                // Max counter operation
                lastMaxCounter = maxCounter;
            }
        }

        // Update all counters to the lastMaxCounter
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < lastMaxCounter) {
                counters[i] = lastMaxCounter;
            }
        }

        return counters;
    }
}
//    This optimized solution still has a time complexity of O(N + M),
//    but it reduces the number of individual updates during the "increase" operations and updates all counters at once during
//        the "max counter" operations.
//    This can lead to better performance for large inputs.
//}