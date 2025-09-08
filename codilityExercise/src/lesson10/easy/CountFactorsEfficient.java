package lesson10.easy;

//Certainly! A more efficient solution takes advantage of the fact that for every factor i of N, there is a corresponding factor N/i.
// By iterating up to the square root of N, you can find both factors in a single loop. Here's the updated Java code:

public class CountFactorsEfficient {
    public int solution(int N) {
        int countFactors = 0;
        int i = 1;

        // Loop through potential factors up to the square root of N
        while ((long) i * i <= N) {
            // Check if i is a factor of N
            if (N % i == 0) {
                // If i is a square root, count it only once
                if (i * i == N) {
                    countFactors++;
                } else {
                    // i and N/i are distinct factors
                    countFactors += 2;
                }
            }
            i++;
        }

        return countFactors;
    }
}

//This solution still has a time complexity of O(sqrt(N)), but it avoids redundant calculations by counting both factors in a single loop.
// The (long) casting is used to handle cases where i * i might exceed the range of int.