package lesson4.medium;

import java.util.Arrays;

//This is a demo task.
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//        Given A = [1, 2, 3], the function should return 4.
//
//        Given A = [−1, −3], the function should return 1.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        each element of array A is an integer within the range [−1,000,000..1,000,000].
public class MissingInteger {
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

//    This solution first sorts the input array in ascending order.
//    Then, it iterates through the sorted array, tracking the smallest positive integer that does not occur in the array.
//    It increments the smallestPositive whenever it finds a match and breaks out of the loop if it encounters a value greater than
//    the current smallestPositive.
//
//    The time complexity of this solution is O(N * log(N)) due to the sorting step.
//    The space complexity is O(1) since the sorting is done in-place.
}
