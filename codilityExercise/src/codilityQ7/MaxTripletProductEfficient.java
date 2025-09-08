package codilityQ7;
public class MaxTripletProductEfficient {

    public static void main(String[] args) {
        int[] A = {-3, 1, 2, -2, 5, 6};
        int result = solution(A);
        System.out.println("Maximal product of any triplet: " + result);
    }

    public static int solution(int[] A) {
        int N = A.length;

        // Initialize the smallest and second smallest values
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Initialize the largest, second largest, and third largest values
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        // Iterate through the array to update the smallest and largest values
        for (int num : A) {
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }

            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }
        }

        // Calculate two possible maximal products:
        // 1. Product of three largest values
        // 2. Product of two smallest values (potentially negative) and the largest value
        int product1 = max1 * max2 * max3;
        int product2 = min1 * min2 * max1;

        // Return the maximum of the two products
        return Math.max(product1, product2);
    }
}

//
//In this solution, we iterate through the array only once, updating the smallest and largest values as we go.
//        This reduces the time complexity to O(N). The space complexity remains O(1) as we use only a constant amount of extra space.


