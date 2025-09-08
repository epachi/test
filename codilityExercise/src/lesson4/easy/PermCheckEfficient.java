package lesson4.easy;

import java.util.HashSet;

//
//To achieve better performance, we can use a boolean array to keep track of the presence of elements from 1 to N.
//        This avoids the need for a HashSet and provides a more efficient solution. Here's the updated Java code:

public class PermCheckEfficient {
    public int solution(int[] A) {
        int N = A.length;

        // Check condition 1: Unique elements
        boolean[] seen = new boolean[N + 1];
        for (int num : A) {
            if (num < 1 || num > N || seen[num]) {
                return 0; // Out of range or duplicate element found
            }
            seen[num] = true;
        }

        // Check condition 2: Elements from 1 to N
        for (int i = 1; i <= N; i++) {
            if (!seen[i]) {
                return 0; // Element missing in the array
            }
        }

        return 1; // Array is a permutation
    }
}

//This solution uses a boolean array seen to keep track of whether each element from 1 to N has been encountered.
// It iterates through the array once, efficiently checking both conditions.
// The time complexity is O(N), and the space complexity is O(N), making it a more optimal solution.