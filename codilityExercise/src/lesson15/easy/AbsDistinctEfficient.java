package lesson15.easy;


import java.util.HashSet;
import java.util.Set;

//Certainly! Since the array is sorted, we can optimize the solution further.
//        Instead of using a set to store absolute values, we can use two pointers to traverse the array and count distinct absolute values without using additional space.
//        Here's the updated Java implementation:
public class AbsDistinctEfficient {
    public int solution(int[] A) {
        int distinctCount = 1;  // At least one absolute value exists (0)

        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int leftValue = Math.abs(A[left]);
            int rightValue = Math.abs(A[right]);

            if (leftValue == rightValue) {
                // Skip duplicates
                while (left < right && A[left] == A[left + 1]) {
                    left++;
                }
                while (left < right && A[right] == A[right - 1]) {
                    right--;
                }

                left++;
                right--;
            } else if (leftValue > rightValue) {
                left++;
            } else {
                right--;
            }

            distinctCount++;
        }

        return distinctCount;
    }
}

//    This solution still has a time complexity of O(N), where N is the length of the array,
//    but it uses constant space. It leverages the fact that the array is sorted to efficiently count distinct absolute values.
