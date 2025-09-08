package exercise4AlgoSkills.easy;
//To achieve a more efficient solution, we can eliminate the need for two separate HashMaps (countMap and positionMap).
//        Instead, we can use a single HashMap to store the count and the last occurrence position of each number.
//        Additionally, we can use a TreeSet to keep track of the unique numbers in a sorted order based on their last occurrence positions.

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FirstUniqueEfficient {
    public int solution(int[] A) {
        HashMap<Integer, Integer> positionMap = new HashMap<>();
        TreeSet<Integer> uniqueNumbers = new TreeSet<>();

        for (int i = 0; i < A.length; i++) {
            int num = A[i];

            if (positionMap.containsKey(num)) {
                // Remove the number from the TreeSet if it's no longer unique
                uniqueNumbers.remove(positionMap.get(num));
            } else {
                // Add the number to the TreeSet as it's currently unique
                uniqueNumbers.add(i);
            }

            // Update the last occurrence position for the current number
            positionMap.put(num, i);
        }

        if (uniqueNumbers.isEmpty()) {
            // No unique numbers found
            return -1;
        }

        // Return the first unique number with the lowest position
        return A[uniqueNumbers.first()];
    }

    public static void main(String[] args) {
        FirstUniqueEfficient solution = new FirstUniqueEfficient();

        // Example 1
        int[] A1 = {1, 4, 3, 3, 1, 2};
        System.out.println(solution.solution(A1)); // Output: 4

        // Example 2
        int[] A2 = {6, 4, 4, 6};
        System.out.println(solution.solution(A2)); // Output: -1
    }
}
//    This optimized solution reduces the space complexity by using only one HashMap and one TreeSet.
//        The TreeSet is used to keep track of unique numbers in sorted order based on their last occurrence positions.
//        The time complexity remains O(N) as we still iterate through the array once.
