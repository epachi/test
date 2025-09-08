package lesson13.medium;
import java.util.*;
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
public class FibFrogClaude {
    public int solution(int[] A) {
        int N = A.length;

        // Generate Fibonacci numbers up to N+1 (maximum possible jump distance)
        List<Integer> fibs = generateFibonacci(N + 1);

        // BFS to find minimum jumps
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // Start from position -1 with 0 jumps
        queue.offer(new int[]{-1, 0});
        visited.add(-1);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int jumps = current[1];

            // Try all possible Fibonacci jumps from current position
            for (int fib : fibs) {
                int nextPosition = position + fib;

                // Check if we can reach the other bank (position N)
                if (nextPosition == N) {
                    return jumps + 1;
                }

                // Check if next position is valid and not visited
                if (nextPosition > 0 && nextPosition < N &&
                        A[nextPosition] == 1 && !visited.contains(nextPosition)) {

                    visited.add(nextPosition);
                    queue.offer(new int[]{nextPosition, jumps + 1});
                }
            }
        }

        // If we can't reach the other side
        return -1;
    }

    /**
     * Generates Fibonacci numbers up to maxValue
     */
    private List<Integer> generateFibonacci(int maxValue) {
        List<Integer> fibs = new ArrayList<>();

        // F(0) = 0, but we don't include it since a jump of 0 doesn't make sense
        // F(1) = 1
        int a = 0, b = 1;

        while (b <= maxValue) {
            fibs.add(b);
            int temp = a + b;
            a = b;
            b = temp;
        }

        return fibs;
    }


    public static void main(String[] args) {
        FibFrogClaude solution = new FibFrogClaude();
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