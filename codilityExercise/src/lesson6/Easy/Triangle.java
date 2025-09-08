package lesson6.Easy;

//An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
//
//A[P] + A[Q] > A[R],
//A[Q] + A[R] > A[P],
//A[R] + A[P] > A[Q].
//For example, consider array A such that:
//
//  A[0] = 10    A[1] = 2    A[2] = 5
//  A[3] = 1     A[4] = 8    A[5] = 20
//Triplet (0, 2, 4) is triangular.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
//
//For example, given array A such that:
//
//  A[0] = 10    A[1] = 2    A[2] = 5
//  A[3] = 1     A[4] = 8    A[5] = 20
//the function should return 1, as explained above. Given array A such that:
//
//  A[0] = 10    A[1] = 50    A[2] = 5
//  A[3] = 1
//the function should return 0.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..100,000];
//each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

//To solve this problem, you can sort the array and then check if there exists a triangular triplet by verifying the triangular inequality conditions.
//
//        Here's the Java implementation:

import lesson5.Easy.PassingCarsEfficient;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
        int N = A.length;

        if (N < 3) {
            return 0; // Not enough elements to form a triplet
        }

        Arrays.sort(A);

        System.out.println("N is:"+N);
        for (int a: A) {
            System.out.print("--->" + a);
        }
        System.out.println("\n");

        for (int i = 0; i < N - 2; i++) {
            System.out.println("===>" + A[i] +", "+A[i+1]+", "+A[i+2]);
            if (A[i] > A[i + 2] - A[i + 1]) {
                return 1; // Triangular triplet found
            }
        }

        return 0; // No triangular triplet found
    }

    public static void main(String[] args) {
        Triangle solution = new Triangle();
        int [] A = {10, 2, 5, 1, 8, 20};

        System.out.println(solution.solution(A));
    }
}

//This solution sorts the array and then iterates through it, checking the triangular inequality condition for each triplet.
// If the condition is satisfied for any triplet, the function returns 1, indicating the presence of a triangular triplet. Otherwise, it returns 0.
//
//The time complexity of this solution is O(N * log(N)), where N is the length of the array due to the sorting operation.
// The space complexity is O(1) as it uses a constant amount of extra space regardless of the input size.