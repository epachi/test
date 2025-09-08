package lesson6.medium;

//Certainly! We can use a sweep line algorithm to count the intersecting pairs more efficiently in O(N log N) time complexity without sorting the entire array.

import java.util.Arrays;

public class NumberOfDiscIntersectionsEfficientWRONG {
    public int solution(int[] A) {
        int N = A.length;

        // Arrays to store the starting and ending points of each disc
        long[] discStarts = new long[N];
        long[] discEnds = new long[N];

        // Populate the arrays with disc starting and ending points
        for (int i = 0; i < N; i++) {
            discStarts[i] = (long) i - A[i];
            discEnds[i] = (long) i + A[i];
        }

        // Sort the arrays of disc starting and ending points
        Arrays.sort(discStarts);
        Arrays.sort(discEnds);

        int intersectingPairs = 0;
        int activeDiscs = 0; // Number of currently active (intersecting) discs

        int j = 0; // Pointer for discEnds array

        // Sweep line algorithm
        for (int i = 0; i < N; i++) {
            // Check how many discs end before the current disc starts
            while (j < N && discEnds[j] < discStarts[i]) {
                activeDiscs--;
                j++;
            }

            // Update the count of intersecting pairs
            intersectingPairs += activeDiscs;

            // Check for the exceeding condition
            if (intersectingPairs > 10_000_000) {
                return -1;
            }

            // Increment the count of currently active discs
            activeDiscs++;
        }

        return intersectingPairs;
    }

    public static void main(String[] args) {
        NumberOfDiscIntersectionsWRONG solution = new NumberOfDiscIntersectionsWRONG();
        int [] A = {1, 5, 2, 1, 4, 0};

        System.out.println(solution.solution(A));
    }
}
//This solution uses a sweep line algorithm to efficiently count the intersecting pairs without sorting the entire array.
// The time complexity is O(N log N) due to the sorting operation, and the space complexity is O(N).
// The algorithm processes the discs in a single pass, making it more efficient for large inputs.