package lesson4.easy;

//Certainly! We can achieve better efficiency by using an array to represent the positions instead of a HashSet.
//        We can use a boolean array to mark the positions where leaves have fallen.
//        Here's an optimized Java implementation:

import java.util.HashSet;

//You can solve this problem efficiently using a HashSet to keep track of the positions where leaves have fallen.
//        Here's a Java implementation:
public class FrogRiverOneEfficient {
    public int solution(int X, int[] A) {
        boolean[] positions = new boolean[X + 1];
        int uncovered = X;

        for (int time = 0; time < A.length; time++) {
            int position = A[time];

            if (!positions[position]) {
                positions[position] = true;
                uncovered--;

                if (uncovered == 0) {
                    return time;
                }
            }
        }

        return -1; // If all positions are not covered
    }
}
//In this solution, we use a boolean array positions to mark the positions where leaves have fallen.
// We also use the variable uncovered to keep track of the number of remaining uncovered positions.
// As soon as uncovered becomes zero, we return the current time.
//
//        This solution has a time complexity of O(N), where N is the length of the array A, and the space complexity is O(X) due to the boolean array. The space complexity is still O(X), but the constant factor is likely smaller than the HashSet implementation,
//        making it more efficient in practice.