package lesson13.medium;

import java.util.*;

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
// Reference: https://www.youtube.com/watch?v=KAfCjYcYJeM
public class FibFrogFromYoutube {
    int [] A;
    int target;
    List<Integer> fibNums;
    List<Integer> positions = new ArrayList<Integer>();

    public int solution(int[] A) {
        this.A = A;
        target = A.length;

        fibNums = new ArrayList<>();
        fibNums.add(0);
        fibNums.add(1);

        for (int i = 0;  ; i++) {
            int nextFibNum = fibNums.get(i) + fibNums.get(i + 1);
            if (nextFibNum <= A.length + 1) {
                fibNums.add(nextFibNum);
            } else {
                break;
            }
        }

        int steps = 0;
        positions.add(-1);

        while (!positions.isEmpty()) {
            steps++;
            if (attemptJump()) {
                return steps;
            }
        }
        return -1;
    }

    private boolean attemptJump() {
        List<Integer>newPositions = new ArrayList<>();

        for (int position : positions) {
            for (int i = fibNums.size() - 1 ; i >=2 ; i--) {
                int fibNum = fibNums.get(i);
                if (position + fibNum == target)  {
                    return true;
                }
                if  (position + fibNum < target) {
                    if (A[position + fibNum] == 1) {
                        A[position + fibNum] = 0;
                        newPositions.add(position+fibNum);
                    }
                }
            }
        }
        positions = newPositions;
        return false;

    }

    public static void main(String[] args) {
        FibFrogFromYoutube solution = new FibFrogFromYoutube();
        int [] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};


        int minJump = solution.solution(A);
        System.out.println("minJump==>" + minJump);
    }
}

//In this optimized version, we only calculate Fibonacci numbers on-the-fly, and we use variables (fibPrev, fibCurrent, fibNext)
// to keep track of the current and previous Fibonacci numbers.
// This reduces memory usage and improves the efficiency of the solution. The main logic of updating the dp array remains the same.