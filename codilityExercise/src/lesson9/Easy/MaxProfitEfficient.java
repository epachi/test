package lesson9.Easy;

//The solution provided is already quite efficient with a time complexity of O(N) where N is the length of the input array.
// However, if you want to optimize it further, you can use a single-pass approach without using the Math.min function. Here's an updated version:
public class MaxProfitEfficient {
    public int solution(int[] A) {
        if (A.length < 2) {
            return 0; // Not enough days for a transaction
        }

        int minPrice = A[0];
        int maxProfit = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] < minPrice) {
                minPrice = A[i];
            } else {
                maxProfit = Math.max(maxProfit, A[i] - minPrice);
            }
        }

        return maxProfit;
    }
}
//In this version, we use a simple if-else statement to update minPrice.
// This avoids the function call overhead of Math.min and may result in a slight performance improvement,
// especially if the language runtime optimizes the simple comparison more effectively.
//
//Remember that the efficiency gain here might be marginal, and it's essential to consider readability and maintainability along with performance optimizations.