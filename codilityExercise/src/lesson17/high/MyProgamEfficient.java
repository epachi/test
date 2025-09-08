package lesson17.high;
//Certainly! You can use the Subset Sum problem's variation to solve this problem more efficiently.
// The idea is to find a subset of the array such that its sum is as close as possible to half of the total sum of the array.
// Here's a Java program using this

import java.util.Arrays;

public class MyProgamEfficient {

    public static int minSubsetSumDifference(int[] arr) {
        int n = arr.length;

        // Calculate the total sum of the array
        int totalSum = Arrays.stream(arr).sum();

        // Calculate the range of possible subset sum
        boolean[][] dp = new boolean[n + 1][totalSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int j = totalSum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                minDiff = totalSum - 2 * j;
                break;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int result = minSubsetSumDifference(arr);
        System.out.println("The minimum difference between two subset sums is: " + result);
    }

}

//This program finds a subset with a sum as close as possible to half of the total sum,
// and the minimum difference is then calculated by subtracting twice the subset sum from the total sum.
// This approach improves the time complexity compared to the previous dynamic programming solution.