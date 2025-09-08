package lesson4.medium;

import java.util.Arrays;

//Certainly! We can achieve better performance by avoiding the sorting step and using a HashSet to efficiently
//        check for the presence of elements.
//        Here's an optimized Java implementation:
public class MissingIntegerEfficient {
    public int solution(int[] A) {
        Arrays.sort(A);

        int smallestPositive = 1;

        for (int value : A) {
            if (value == smallestPositive) {
                smallestPositive++;
            } else if (value > smallestPositive) {
                break;
            }
        }

        return smallestPositive;
    }

//    In this solution, we iterate through the array once to populate a HashSet (seenNumbers) with the unique values.
//    Then, we use a while loop to find the smallest positive integer that does not occur in the array.
//
//    This approach has a time complexity of O(N) since we iterate through the array only once, and the HashSet lookup
//    operation has an average time complexity of O(1). The space complexity is O(N) to store the unique values in the HashSet.
//    This solution can be more efficient than the sorting-based solution, especially for large arrays.
}
