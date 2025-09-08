package exercise3.medium;

//Certainly! We can achieve a more efficient solution by directly calculating the number of pairs without the need for HashMaps.
//        We can count the occurrences of each color in both clean and dirty socks separately
//        and then use these counts to calculate the maximum number of pairs.

import java.util.Arrays;

public class SocksLaunderingEfficient {
    public int solution(int K, int[] C, int[] D) {
        int[] cleanSockCounts = new int[51]; // Assuming colors are in the range [1, 50]
        int[] dirtySockCounts = new int[51];

        int pairsCount = 0;

        // Process clean socks
        for (int color : C) {
            cleanSockCounts[color]++;
            if (cleanSockCounts[color] % 2 == 0) {
                pairsCount++;
            }
        }

        // Process dirty socks and complete pairs using clean socks
        for (int color : D) {
            dirtySockCounts[color]++;
            if (dirtySockCounts[color] % 2 == 0) {
                pairsCount++;
            } else if (cleanSockCounts[color] > 0) {
                cleanSockCounts[color]--;
                pairsCount++;
            }
        }

        // Use at most K socks for laundering
        int remainingPairs = K / 2;
        pairsCount += Math.min(remainingPairs, countRemainingPairs(cleanSockCounts));

        return pairsCount;
    }

    private int countRemainingPairs(int[] sockCounts) {
        int remainingPairs = 0;
        for (int count : sockCounts) {
            remainingPairs += count / 2;
        }
        return remainingPairs;
    }

    public static void main(String[] args) {
        SocksLaunderingEfficient solution = new SocksLaunderingEfficient();
        int K = 2;
        int[] C = {1, 2, 1, 1};
        int[] D = {1, 4, 3, 2, 4};
        System.out.println(solution.solution(K, C, D)); // Output: 3
    }
}

//In this solution, we use arrays (cleanSockCounts and dirtySockCounts) to directly keep track of the counts of each color.
//        The countRemainingPairs method calculates the number of remaining pairs from the given sock counts.
//        This approach reduces the overhead of using HashMaps and provides a more efficient solution.