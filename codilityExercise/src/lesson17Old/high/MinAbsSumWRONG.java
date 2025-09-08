package lesson17Old.high;

import java.util.Arrays;

//For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:
//
//val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
//
//(Assume that the sum of zero elements equals zero.)
//
//For a given array A, we are looking for such a sequence S that minimizes val(A,S).
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.
//
//For example, given array:
//
//  A[0] =  1
//  A[1] =  5
//  A[2] =  2
//  A[3] = -2
//your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..20,000];
//each element of array A is an integer within the range [−100..100].

//
//To solve this problem, we can observe that for each element in array A,
//        it contributes to the minimum value when multiplied by the corresponding element in sequence S with the opposite sign.
//        So, we can aim to make the sum of products as close to zero as possible.
public class MinAbsSumWRONG {
    public int solution(int[] A) {
        int N = A.length;
        int[] absA = new int[N];

        for (int i = 0; i < N; i++) {
            absA[i] = Math.abs(A[i]);
        }

        Arrays.sort(absA);

        int sum = 0;
        for (int i = 0; i < N / 2; i++) {
            sum += absA[i] * 2;
        }

        if (N % 2 == 1) {
            sum += absA[N / 2];
        }

        return sum;
    }

    public static void main(String[] args) {
        MinAbsSumWRONG solution = new MinAbsSumWRONG();
        int[] A = {1, 5, 2, -2};
        System.out.println(solution.solution(A)); // Output: 0
    }
}

//
//In this solution, we first create an array absA containing the absolute values of elements in A. We sort this array in ascending order.
//        Then, we sum the double of the smallest half of the sorted absA array. If the length of the array is odd, we add the absolute value of the middle element as well.
//
//        This approach ensures that we minimize the sum of products by pairing the smallest absolute values with the largest ones.
//        The time complexity of the solution is O(N * log(N)) due to the sorting step.