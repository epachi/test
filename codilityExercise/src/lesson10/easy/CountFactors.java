package lesson10.easy;

//A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
//
//For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
//
//Write a function:
//
//class Solution { public int solution(int N); }
//
//that, given a positive integer N, returns the number of its factors.
//
//For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..2,147,483,647].

public class CountFactors {
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

//This solution iterates through potential factors up to the square root of N and counts both the factors and their complements.
// It avoids redundant calculations by checking if i * i == N to handle square roots separately.
//
//The time complexity of this solution is O(sqrt(N)), making it efficient for the given range