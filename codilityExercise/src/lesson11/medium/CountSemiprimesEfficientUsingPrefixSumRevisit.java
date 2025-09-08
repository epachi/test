package lesson11.medium;

//Certainly! We can further optimize the solution by reducing the time complexity for calculating semiprimes using the Sieve of Eratosthenes.
//
//Here's an updated Java code:

public class CountSemiprimesEfficientUsingPrefixSumRevisit {
    public int[] solution(int N, int[] P, int[] Q) {
        int[] prefixSemiprimes = new int[N + 1];
        int[] result = new int[P.length];

        // Use an array to store the smallest prime factor for each number
        int[] smallestPrimeFactor = new int[N + 1];

        // Calculate semiprimes using the <<<<prefix sums>>>>>
        for (int i = 2; i * i <= N; i++) {
            if (smallestPrimeFactor[i] == 0) {
                for (int j = i * i; j <= N; j += i) {
                    if (smallestPrimeFactor[j] == 0) {
                        smallestPrimeFactor[j] = i;
                    }
                }
            }
        }

        // Calculate semiprimes using the prefix sums
        for (int i = 4; i <= N; i++) {
            if (smallestPrimeFactor[i] == 0) {
                for (int j = i; j <= N; j += i) {
                    if (smallestPrimeFactor[j / i] == 0) {
                        prefixSemiprimes[j]++;
                    }
                }
            }
        }

        // Calculate <<<<<prefix sums>>>>>>
        for (int i = 1; i <= N; i++) {
            prefixSemiprimes[i] += prefixSemiprimes[i - 1];
        }

        // Answer the queries
        for (int i = 0; i < P.length; i++) {
            result[i] = prefixSemiprimes[Q[i]] - prefixSemiprimes[P[i] - 1];
        }

        return result;
    }
}

//In this version, we use the smallestPrimeFactor array to store the smallest prime factor for each number during the Sieve of Eratosthenes.
// This allows us to avoid unnecessary checks in the second loop. The time complexity is still O(N * log(log(N)) + M).