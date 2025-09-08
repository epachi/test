package lesson9.medium;

//A non-empty array A consisting of N integers is given.
//
//A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
//
//The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
//
//For example, array A such that:
//
//    A[0] = 3
//    A[1] = 2
//    A[2] = 6
//    A[3] = -1
//    A[4] = 4
//    A[5] = 5
//    A[6] = -1
//    A[7] = 2
//contains the following example double slices:
//
//double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
//double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
//double slice (3, 4, 5), sum is 0.
//The goal is to find the maximal sum of any double slice.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
//
//For example, given:
//
//    A[0] = 3
//    A[1] = 2
//    A[2] = 6
//    A[3] = -1
//    A[4] = 4
//    A[5] = 5
//    A[6] = -1
//    A[7] = 2
//the function should return 17, because no double slice of array A has a sum of greater than 17.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [3..100,000];
//each element of array A is an integer within the range [−10,000..10,000].
//
//To solve this problem, you can use dynamic programming to compute the maximum sum of slices ending at each position and another array for the maximum sum of slices starting at each position.
//        Then, iterate through each possible middle element of the double slice and find the maximum sum




public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        int N = A.length;

        // Calculate the maximum sum of slices ending at each position
        int[] maxEnding = new int[N];
        for (int i = 1; i < N - 1; i++) {
            maxEnding[i] = Math.max(maxEnding[i - 1] + A[i], 0);
        }

System.out.print("maxEndings:");
for (int i = 0; i < N ; i++) {
    System.out.println("==>" + maxEnding[i]);
}

        // Calculate the maximum sum of slices starting at each position
        int[] maxStarting = new int[N];
        for (int i = N - 2; i > 0; i--) {
            maxStarting[i] = Math.max(maxStarting[i + 1] + A[i], 0);
        }

System.out.print("maxStartings:");
for (int i = 0; i < N ; i++) {
    System.out.println("==>" + maxStarting[i]);
}

        // Find the maximum double slice sum
        int maxDoubleSliceSum = 0;
        for (int i = 1; i < N - 1; i++) {
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, maxEnding[i - 1] + maxStarting[i + 1]);
        }

        return maxDoubleSliceSum;
    }

    public static void main(String[] args) {
        int result1 = (new MaxDoubleSliceSum()).solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2});
        System.out.println("MaxDoubleSliceSum: " + result1);

    }
}
//This algorithm has a time complexity of O(N) as it iterates through the array three times sequentially.
// The three passes are for computing the maximum sum of slices ending at each position,
// the maximum sum of slices starting at each position, and finding the maximum double slice sum.
//
//Keep in mind that the indices for slices are adjusted to exclude the first and last elements, as the definition excludes the endpoints for a double slice.