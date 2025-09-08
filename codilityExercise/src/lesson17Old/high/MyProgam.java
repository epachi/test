package lesson17Old.high;
//For a given array A of N positive integers, divide N positive integers into two groups X and Y so that the
// difference of sum of integers in group X and group Y is minimum. Could you write a Java program to achieve this.

//Certainly! To solve this problem, you can use dynamic programming to find the minimum difference between the sums of two groups.
//        Here's a simple Java program that demonstrates how to achieve this:

import java.util.Arrays;
public class MyProgam {

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
//        int[] arr = {1, 6, 11, 5};
        int[] arr = {1, 2, 2, 5};
        int result = minSubsetSumDifference(arr);
        System.out.println("The minimum difference between two subset sums is: " + result);
    }
}

