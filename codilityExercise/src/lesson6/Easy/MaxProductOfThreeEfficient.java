package lesson6.Easy;

//Certainly! We can achieve a more efficient solution with O(N) time complexity without sorting the entire array. Here's an updated implementation:
import java.util.Arrays;

public class MaxProductOfThreeEfficient {
    public int solution(int[] A) {
        int N = A.length;

        // Find the three largest numbers and the two smallest numbers
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : A) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        // The maximal product can be either the product of three largest numbers
        // or the product of two smallest numbers (if they are negative) and the largest number
        int product1 = max1 * max2 * max3;
        int product2 = min1 * min2 * max1;

        return Math.max(product1, product2);
    }
}

//This solution iterates through the array only once to find the three largest numbers and the two smallest numbers.
// It then calculates the two possible products and returns the maximum of them.
//
//The time complexity is O(N), and the space complexity is O(1). This approach is more efficient than sorting, especially for large arrays.