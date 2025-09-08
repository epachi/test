package lesson11.medium;

//You are given an array A consisting of N integers.
//
//For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that
// re not the divisors of A[i]. We say that these elements are non-divisors.
//
//For example, consider integer N = 5 and array A such that:
//
//    A[0] = 3
//    A[1] = 1
//    A[2] = 2
//    A[3] = 3
//    A[4] = 6
//For the following elements:
//
//A[0] = 3, the non-divisors are: 2, 6,
//A[1] = 1, the non-divisors are: 3, 2, 3, 6,
//A[2] = 2, the non-divisors are: 3, 3, 6,
//A[3] = 3, the non-divisors are: 2, 6,
//A[4] = 6, there aren't any non-divisors.
//Write a function:
//
//class Solution { public int[] solution(int[] A); }
//
//that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.
//
//Result array should be returned as an array of integers.
//
//For example, given:
//
//    A[0] = 3
//    A[1] = 1
//    A[2] = 2
//    A[3] = 3
//    A[4] = 6
//the function should return [2, 4, 3, 2, 0], as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..50,000];
//each element of array A is an integer within the range [1..2 * N].

//

import java.util.HashMap;

public class CountNonDivisible {
    public int[] solution(int[] A) {
        int N = A.length;

        // Count occurrences of each number in A
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int num : A) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);             //<====== occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // Count non-divisors for each number in A
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int num = A[i];
            int count = 0;

            // Iterate through divisors
            for (int divisor : occurrences.keySet()) {
                if (num % divisor != 0) {
                    count += occurrences.get(divisor);
                }
            }

            // Subtract occurrences of the number itself
//            result[i] = N - count;
            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        CountNonDivisible solution = new CountNonDivisible();
        int [] input = { 3, 1, 2, 3, 6};
        int [] nonDivisorCount = solution.solution(input);

        for (int i = 0 ; i < input.length ; i++) {
           System.out.println("-->" + nonDivisorCount[i]);

        }
    }
}

//This solution uses a HashMap to count the occurrences of each number in the array.
// Then, for each number in the array, it iterates through the divisors and counts the non-divisors.
// The result array is then populated with the counts.