package lesson6.medium;

import java.util.Arrays;

// Ref: lesson 48 of https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14143405#overview


public class NumberOfDiscIntersections100PercentRevisit {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }

        // Use long to prevent overflow for start and end points
        long[] startPoints = new long[N];
        long[] endPoints = new long[N];

        for (int i = 0; i < N; i++) {
            startPoints[i] = (long) i - A[i];
            endPoints[i] = (long) i + A[i];
        }

        // Sort the start and end points
        Arrays.sort(startPoints);
        Arrays.sort(endPoints);

        int intersections = 0;
        int activeDiscs = 0; // Number of discs that are currently "open" (their start point has been encountered, but not their end point)
        int endIndex = 0;    // Pointer for the endPoints array

        // Iterate through the sorted start points
        for (int startIndex = 0; startIndex < N; startIndex++) {
            // While the current end point is less than the current start point,
            // it means a disc has ended. Decrement activeDiscs.
            while (endIndex < N && endPoints[endIndex] < startPoints[startIndex]) {
                activeDiscs--;
                endIndex++;
            }

            // At this point, the current disc (startPoints[startIndex])
            // will intersect with all currently active discs.
            // Each active disc means one intersection with the current disc.
            intersections += activeDiscs;

            // Check for overflow early
            if (intersections > 10_000_000) {
                return -1;
            }

            // The current disc itself now becomes active
            activeDiscs++;
        }

        return intersections;
    }

    public static void main(String[] args) {
        NumberOfDiscIntersections100PercentRevisit solution = new NumberOfDiscIntersections100PercentRevisit();
        int [] A = {1, 5, 2, 1, 4, 0};

        System.out.println(solution.solution(A));
    }
}

