package lesson11.medium;

//A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
//
//A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
//
//You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
//
//Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
//
//For example, consider an integer N = 26 and arrays P, Q such that:
//
//    P[0] = 1    Q[0] = 26
//    P[1] = 4    Q[1] = 10
//    P[2] = 16   Q[2] = 20
//The number of semiprimes within each of these ranges is as follows:
//
//(1, 26) is 10,
//(4, 10) is 4,
//(16, 20) is 0.
//Write a function:
//
//class Solution { public int[] solution(int N, int[] P, int[] Q); }
//
//that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting
// of M elements specifying the consecutive answers to all the queries.
//
//For example, given an integer N = 26 and arrays P, Q such that:
//
//    P[0] = 1    Q[0] = 26
//    P[1] = 4    Q[1] = 10
//    P[2] = 16   Q[2] = 20
//the function should return the values [10, 4, 0], as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..50,000];
//M is an integer within the range [1..30,000];
//each element of arrays P and Q is an integer within the range [1..N];
//P[i] ≤ Q[i].

//To solve this problem efficiently, we can use the concept of <<<<<prefix sums>>>>>. First, we'll calculate the number of semiprimes up to each position in the array.
// Then, for each query, we can quickly find the number of semiprimes in the given range using the prefix sums.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CountSemiprimesWRONG {

    /**
     * Finds the number of semiprimes within specified ranges.
     *
     * @param N The upper bound of the numbers to consider.
     * @param P An array representing the start of the query ranges.
     * @param Q An array representing the end of the query ranges.
     * @return An array containing the count of semiprimes for each query range.
     */
    public int[] solution(int N, int[] P, int[] Q) {

        // Step 1: Use Sieve of Eratosthenes to find all prime numbers up to N.
        // The array 'F' will store the smallest prime factor of each number.
        int[] F = new int[N + 1];
        for (int i = 2; i * i <= N; i++) {
            if (F[i] == 0) { // i is prime
                for (int k = i * i; k <= N; k += i) {
                    if (F[k] == 0) {
                        F[k] = i; // k is a multiple of i, so i is its smallest prime factor
                    }
                }
            }
        }
printArray(F, "Prime");

        // Step 2: Identify all semiprimes up to N.
        // A number x is semiprime if x = p * q where p and q are primes.
        // This is equivalent to F[x] != 0 (so x is not prime) and F[x / F[x]] == 0
        // (the other factor is prime).
        boolean[] isSemiPrime = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (F[i] != 0) { // i is a composite number
                int firstFactor = F[i];
                int secondFactor = i / firstFactor;
                if (F[secondFactor] == 0) { // The second factor is prime
                    isSemiPrime[i] = true;
                }
            }
        }
printBoolArray(isSemiPrime, "semiPrime");
        // Step 3: Create a prefix sum array for the counts of semiprimes.
        // semiPrimePrefixCount[i] will store the total number of semiprimes up to i.
        int[] semiPrimePrefixCount = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            semiPrimePrefixCount[i] = semiPrimePrefixCount[i - 1];
            if (isSemiPrime[i]) {
                semiPrimePrefixCount[i]++;
            }
        }
printArray(semiPrimePrefixCount, "semiPrimePrefixCount");
        // Step 4: Process each query using the prefix sum array.
        int M = P.length;
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int start = P[i];
            int end = Q[i];
            // The count in range [start, end] is the total count up to 'end'
            // minus the total count up to 'start - 1'.
            result[i] = semiPrimePrefixCount[end] - semiPrimePrefixCount[start - 1];
        }

        return result;

    }

    public static void main(String[] args) {
//        CountSemiprimesWRONG solution = new CountSemiprimesWRONG();
        int [] P= { 1, 4, 16};
        int [] Q= { 26, 10, 20};
        int N = 26;


        int [] result = (new CountSemiprimesWRONG()).solution(N, P, Q);
        for (int i = 0 ; i < result.length ; i++) {
            System.out.println("==>" + result[i]);

        }
    }

    private void printArray(int [] A, String message) {
        for (int i = 0; i < A.length ; i++) {
            System.out.println(message+">>>" + i+ "]" + A[i]);
        }
    }

    private void printBoolArray(boolean [] A, String message) {
        for (int i = 0; i < A.length ; i++) {
            System.out.println(message+">>>" + i+ "]" + A[i]);
        }
    }
}