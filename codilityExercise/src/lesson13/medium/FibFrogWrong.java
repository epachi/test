package lesson13.medium;

//The Fibonacci sequence is defined using the following recursive formula:
//
//    F(0) = 0
//    F(1) = 1
//    F(M) = F(M - 1) + F(M - 2) if M >= 2
//A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1)
// and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number.
// Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.
//
//The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive
// positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
//
//0 represents a position without a leaf;
//1 represents a position containing a leaf.
//The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.
//
//For example, consider array A such that:
//
//    A[0] = 0
//    A[1] = 0
//    A[2] = 0
//    A[3] = 1
//    A[4] = 1
//    A[5] = 0
//    A[6] = 1
//    A[7] = 0
//    A[8] = 0
//    A[9] = 0
//    A[10] = 0
//The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.
//
//For example, given:
//
//    A[0] = 0
//    A[1] = 0
//    A[2] = 0
//    A[3] = 1
//    A[4] = 1
//    A[5] = 0
//    A[6] = 1
//    A[7] = 0
//    A[8] = 0
//    A[9] = 0
//    A[10] = 0
//the function should return 3, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..100,000];
//each element of array A is an integer that can have one of the following values: 0, 1.

import java.util.ArrayList;
import java.util.List;

//To solve this problem efficiently, we can use a dynamic programming approach.
// We will iterate through the array and calculate the minimum number of jumps required to reach each position.
public class FibFrogWrong {
    public int solution(int[] A) {
        int n = A.length;
        int[] dp = new int[n + 2];
        int fibMax = fibMax(n);

        // Initialize dp array
        for (int i = 0; i <= n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        // Update dp array
        for (int i = 1; i <= n + 1; i++) {
            if (i <= n && A[i - 1] == 1) {
                for (int f : fibonacciNumbers(fibMax)) {
                    if (i - f >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - f] + 1);
                    }
                }
            }
        }

        return dp[n + 1] == Integer.MAX_VALUE ? -1 : dp[n + 1];
    }

    // Helper function to find the maximum Fibonacci number less than or equal to N
    private int fibMax(int n) {
        int a = 0, b = 1;
        while (b <= n) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return a;
    }

    // Helper function to generate Fibonacci numbers up to a given limit
    private List<Integer> fibonacciNumbers(int limit) {
        List<Integer> fibNumbers = new ArrayList<>();
        int a = 0, b = 1;
        while (a <= limit) {
            fibNumbers.add(a);
            int temp = b;
            b = a + b;
            a = temp;
        }
        return fibNumbers;
    }


    public static void main(String[] args) {
        FibFrogWrong solution = new FibFrogWrong();
        int [] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};


        int minJump = solution.solution(A);
        System.out.println("minJump==>" + minJump);
    }
}


//    This solution uses dynamic programming to calculate the minimum number of jumps for each position in the array.
//        The fibonacciNumbers function generates Fibonacci numbers up to a given limit,
//        and the fibMax function finds the maximum Fibonacci number less than or equal to N.
//        The main loop updates the dp array based on the presence of leaves in the river.
//        Finally, the function returns the minimum number of jumps to reach the other side of the river or -1 if it's not possible.