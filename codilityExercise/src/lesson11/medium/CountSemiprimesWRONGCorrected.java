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

public class CountSemiprimesWRONGCorrected {
    public int[] solution(int N, int[] P, int[] Q) {
        int[] prefixSemiprimes = new int[N + 1];
        int[] result = new int[P.length];

        // Calculate semiprimes up to each position using the Sieve of Eratosthenes
        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

printBoolArray("isNotPrime", isNotPrime);

        // Calculate semiprimes using the prefix sums
        for (int i = 4; i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i; j <= N; j += i) {
                    if (!isNotPrime[j / i]) {
                        prefixSemiprimes[j]++;
                    }
                }
            }
        }
printArray("prefixSemiprimes", prefixSemiprimes);
        // Calculate prefix sums
        for (int i = 1; i <= N; i++) {
            prefixSemiprimes[i] += prefixSemiprimes[i - 1];
        }
System.out.println("After prefix sum");
printArray("prefixSemiprimes", prefixSemiprimes);
        // Answer the queries
        for (int i = 0; i < P.length; i++) {
            result[i] = prefixSemiprimes[Q[i]] - prefixSemiprimes[P[i] - 1];
        }
printArray("result", result);
        return result;
    }

    private void printArray(String title, int [] arr){
        System.out.print(title + ": ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(title+"["+i+"]-->" + arr[i]);
        }
        System.out.println("\n");
    }

    private void printBoolArray(String title, boolean [] arr){
        System.out.print(title + ": ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(title+"["+i+"]-->" + arr[i]);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        CountNonDivisible solution = new CountNonDivisible();
        int [] P= { 1, 4, 16};
        int [] Q= { 26, 10, 20};
        int N = 26;


        int [] result = (new CountSemiprimesWRONGCorrected()).solution(N, P, Q);
        for (int i = 0 ; i < result.length ; i++) {
            System.out.println("==>" + result[i]);

        }
    }
}
//This solution has a time complexity of O(N * log(log(N)) + M).
// The time complexity is dominated by the Sieve of Eratosthenes, and the prefix sums allow us to answer each query in constant time.