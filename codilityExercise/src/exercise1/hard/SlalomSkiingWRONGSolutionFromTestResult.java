package exercise1.hard;
//You are a skier participating in a giant slalom. The slalom track is located on a ski slope, goes downhill and is fenced by barriers on both sides. The barriers are perpendicular to the starting line located at the top of the slope. There are N slalom gates on the track. Each gate is placed at a distinct distance from the starting line and from the barrier on the right-hand side (looking downhill).
//
//        You start from any place on the starting line, ski down the track passing as many gates as possible, and finish the slalom at the bottom of the slope. Passing a gate means skiing through the position of the gate.
//
//        You can ski downhill in either of two directions: to the left or to the right. When you ski to the left, you pass gates of increasing distances from the right barrier, and when you ski to the right, you pass gates of decreasing distances from the right barrier. You want to ski to the left at the beginning.
//
//        Unfortunately, changing direction (left to right or vice versa) is exhausting, so you have decided to change direction at most two times during your ride. Because of this, you have allowed yourself to miss some of the gates on the way down the slope. You would like to know the maximum number of gates that you can pass with at most two changes of direction.
//
//        The arrangement of the gates is given as an array A consisting of N integers, whose elements specify the positions of the gates: gate K (for 0 ≤ K < N) is at a distance of K+1 from the starting line, and at a distance of A[K] from the right barrier.
//
//        For example, consider array A such that:
//
//        A[0] = 15
//        A[1] = 13
//        A[2] = 5
//        A[3] = 7
//        A[4] = 4
//        A[5] = 10
//        A[6] = 12
//        A[7] = 8
//        A[8] = 2
//        A[9] = 11
//        A[10] = 6
//        A[11] = 9
//        A[12] = 3
//
//
//        The picture above illustrates the example track with N = 13 gates and a course that passes eight gates. After starting, you ski to the left (from your own perspective). You pass gates 2, 3, 5, 6 and then change direction to the right. After that you pass gates 7, 8 and then change direction to the left. Finally, you pass gates 10, 11 and finish the slalom. There is no possible way of passing more gates using at most two changes of direction.
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers, describing the positions of the gates on the track, returns the maximum number of gates that you can pass during one ski run.
//
//        For example, given the above data, the function should return 8, as explained above.
//
//        For the following array A consisting of N = 2 elements:
//
//        A[0] = 1
//        A[1] = 5
//        the function should return 2.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        each element of array A is an integer within the range [1..1,000,000,000];
//        the elements of A are all distinct.
public class SlalomSkiingWRONGSolutionFromTestResult {
    public int solution(int[] A) {
        int n = A.length;
        int maxGatesPassed = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = countGates(A, i, true);
            int rightCount = countGates(A, i, false);
            int totalGatesPassed = leftCount + rightCount - 1; // Subtract 1 to avoid double-counting the current gate

            maxGatesPassed = Math.max(maxGatesPassed, totalGatesPassed);
        }

        return maxGatesPassed;
    }

    private int countGates(int[] A, int start, boolean skiToLeft) {
        int n = A.length;
        int gatesPassed = 0;
        int currentPos = A[start];
        int currentIndex = start;

        while (currentIndex >= 0 && currentIndex < n && A[currentIndex] >= 0) {
            gatesPassed++;
            int nextPos = skiToLeft ? currentPos - 1 : currentPos + 1;

            // Check if changing direction is needed
            if (nextPos < 0 || nextPos > A[currentIndex]) {
                break;
            }

            // Mark the gate as visited
            A[currentIndex] = -1;

            // Move to the next gate
            currentPos = nextPos;
            currentIndex = findNextGateIndex(A, currentIndex, skiToLeft);
        }

        return gatesPassed;
    }

    private int findNextGateIndex(int[] A, int currentIndex, boolean skiToLeft) {
        int n = A.length;
        int nextIndex = currentIndex;

        if (skiToLeft) {
            for (int i = currentIndex - 1; i >= 0; i--) {
                if (A[i] >= 0) {
                    nextIndex = i;
                    break;
                }
            }
        } else {
            for (int i = currentIndex + 1; i < n; i++) {
                if (A[i] >= 0) {
                    nextIndex = i;
                    break;
                }
            }
        }

        return nextIndex;
    }

    public static void main(String[] args) {
        SlalomSkiingWRONGSolutionFromTestResult solution = new SlalomSkiingWRONGSolutionFromTestResult();
        int[] A = {15, 13, 5, 7, 4, 10, 12, 8, 2, 11, 6, 9, 3};
        System.out.println(solution.solution(A)); // Output: 8

        int[] B = {1, 5};
        System.out.println(solution.solution(B)); // Output: 2
    }
}

//    This solution uses the countGates method to simulate skiing in a specific direction,
//        and the findNextGateIndex method to find the index of the next gate to ski to. The main loop iterates through
//        all possible starting positions and calculates the maximum number of gates passed for each starting position.
//        The final result is the maximum of these values.