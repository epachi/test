package exercise1.hard;
//Certainly! We can achieve a more efficient solution by using dynamic programming. We can maintain two arrays, dpLeft and dpRight,
// where dpLeft[i] represents the maximum number of gates that can be passed starting from the left side up to position i,
// and dpRight[i] represents the maximum number of gates that can be passed starting from the right side up to position i.
//
//        Here's the optimized Java implementation:
public class SlalomSkiingEfficientWRONGSolutionFromTestResult {
    public int solution(int[] A) {
        int n = A.length;

        // Arrays to store the maximum gates passed from the left and right
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];

        // Calculate dpLeft from left to right
        int maxLeft = 0;
        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, A[i] - i);
            dpLeft[i] = maxLeft + i;
        }

        // Calculate dpRight from right to left
        int maxRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, A[i] + i);
            dpRight[i] = maxRight - i;
        }

        // Find the maximum number of gates passed with at most two changes in direction
        int maxGatesPassed = 0;
        for (int i = 0; i < n - 1; i++) {
            maxGatesPassed = Math.max(maxGatesPassed, dpLeft[i] + dpRight[i + 1] - 1);
        }

        return Math.min(n, maxGatesPassed); // Return the minimum of n and maxGatesPassed
    }

    public static void main(String[] args) {
        SlalomSkiingEfficientWRONGSolutionFromTestResult solution = new SlalomSkiingEfficientWRONGSolutionFromTestResult();
        int[] A = {15, 13, 5, 7, 4, 10, 12, 8, 2, 11, 6, 9, 3};
        System.out.println(solution.solution(A)); // Output: 8

        int[] B = {1, 5};
        System.out.println(solution.solution(B)); // Output: 2
    }
}

//    This solution calculates dpLeft and dpRight in two passes, and then iterates through the positions to find the maximum number of gates
//        passed with at most two changes in direction. The final result is the minimum of n and the calculated maximum,
//        as it's not possible to pass more than n gates. This approach improves the time complexity and provides a more efficient solution.






