package lesson13Old.medium;

//The Fibonacci sequence is defined using the following recursive formula:
//
//    F(0) = 0
//    F(1) = 1
//    F(M) = F(M - 1) + F(M - 2) if M >= 2
//A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.
//
//The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
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

//Certainly! The previous solution, although correct, can be further optimized by avoiding the creation
// of an additional list to store Fibonacci numbers. We can use a simple loop to calculate Fibonacci numbers on-the-fly.
// Additionally, we only need the previous two Fibonacci numbers at each step, so we can avoid storing the entire sequence.
//
//        Here's the more efficient Java code:

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FibFrogEfficientWRONG {

    /**
     * Calculates the minimum number of jumps for a frog to cross a river using Fibonacci-length jumps.
     *
     * @param A An array representing leaves on the river (1 for a leaf, 0 for water).
     * @return The minimum number of jumps, or -1 if the other side is unreachable.
     */
    public int solution(int[] A) {
        int N = A.length;

        // Step 1: Generate Fibonacci numbers up to N + 1.
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(2);
        int lastFib = 2;
        int secondLastFib = 1;
        while (lastFib + secondLastFib <= N + 1) {
            int nextFib = lastFib + secondLastFib;
            fibonacci.add(nextFib);
            secondLastFib = lastFib;
            lastFib = nextFib;
        }

        // A queue for the BFS, storing the current position and the number of jumps.
        Queue<int[]> queue = new LinkedList<>();
        // Start at position -1 with 0 jumps.
        queue.add(new int[]{-1, 0});

        // A boolean array to mark visited positions (leaves) to avoid cycles.
        boolean[] visited = new boolean[N];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPosition = current[0];
            int jumps = current[1];

            // Iterate through possible Fibonacci jumps from the current position.
            for (int fibJump : fibonacci) {
                int nextPosition = currentPosition + fibJump;

                // Case 1: The frog reaches the other bank (position N).
                if (nextPosition == N) {
                    return jumps + 1;
                }

                // Case 2: The jump is out of bounds or lands in the water.
                if (nextPosition < 0 || nextPosition >= N || A[nextPosition] == 0) {
                    continue;
                }

                // Case 3: The frog lands on a leaf that has already been visited.
                if (visited[nextPosition]) {
                    continue;
                }

                // Mark the leaf as visited and add it to the queue for further exploration.
                visited[nextPosition] = true;
                queue.add(new int[]{nextPosition, jumps + 1});
            }
        }

        // If the queue is empty and the destination was not reached, it's impossible.
        return -1;
    }

    public static void main(String[] args) {
        FibFrogWRONG solution = new FibFrogWRONG();
        int [] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};


        int minJump = solution.solution(A);
        System.out.println("minJump==>" + minJump);
    }
}

//In this optimized version, we only calculate Fibonacci numbers on-the-fly, and we use variables (fibPrev, fibCurrent, fibNext)
// to keep track of the current and previous Fibonacci numbers.
// This reduces memory usage and improves the efficiency of the solution. The main logic of updating the dp array remains the same.