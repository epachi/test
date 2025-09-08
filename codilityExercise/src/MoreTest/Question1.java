package MoreTest;

import java.util.*;

//Write a Java function solution that, given a string S of length N,
//returns the length of the shortest unique substring of S, that is,
//the length of the shortest word which occurs in S exactly once.
//
//Examples:
//        1. Given S = "abaaba", the function should return 2. The shortest unique substring of S is "aa".
//        2. Given S = "zyzyzyz", the function should return 5. The shortest unique substring of S is "yzyzy".
//Note that there are shorter words,
//like "yzy", occurrences of which overlap, but they still count as multiple Occurrences.
//        3. Given S = "aabbbabaaa", the function should return 3. All substrings of size 2 occurs in S at least twice.
//Assume that:
//        - N is an integer within the range [1..200];
//        - string S is made only of lowercase letters (a-z).
//In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

public class Question1 {    /**
 * Given a string S, this function returns the length of the shortest substring
 * that occurs in S exactly once.
 *
 * @param S The input string, consisting of lowercase letters 'a'-'z'.
 * @return The length of the shortest unique substring.
 */
public int solution(String S) {
    int n = S.length();

    // We will check for unique substrings of increasing length, from 1 to n.
    // The first length for which we find a unique substring will be our answer.
    for (int len = 1; len <= n; len++) {

        // This map will store each substring of the current length and its frequency.
        Map<String, Integer> substringCounts = new HashMap<>();

        // First, we generate all substrings of the current length 'len' and count them.
        for (int i = 0; i <= n - len; i++) {
            String sub = S.substring(i, i + len);
            // Increment the count for this substring.
            substringCounts.put(sub, substringCounts.getOrDefault(sub, 0) + 1);     //<== substringCounts.getOrDefault(sub, 0)
        }

        // After counting, we check if any substring of this length appeared exactly once.
        // We iterate through the substrings in their order of appearance to ensure
        // we correctly evaluate based on the first unique one found.
        for (int i = 0; i <= n - len; i++) {
            String sub = S.substring(i, i + len);
            if (substringCounts.get(sub) == 1) {
                // Since we are iterating 'len' from 1 upwards, the first time we
                // find a unique substring, its length must be the shortest possible.
                // So, we can return this length immediately.
                return len;
            }
        }
    }

    // This case should not be reached based on the problem description,
    // as a unique substring is guaranteed to exist (at worst, the string S itself).
    // However, returning n is a logical fallback.
    return n;
}

    /**
     * Main method for testing the solution with the provided examples.
     */
    public static void main(String[] args) {
        Question1 sol = new Question1();

        // Example 1: S = "abaaba" -> Expected output: 2
        String s1 = "abaaba";
        System.out.println("Input: " + s1);
        System.out.println("Shortest unique substring length: " + sol.solution(s1)); // Output: 2

        System.out.println("--------------------");

        // Example 2: S = "zyzyzyz" -> Expected output: 5
        String s2 = "zyzyzyz";
        System.out.println("Input: " + s2);
        System.out.println("Shortest unique substring length: " + sol.solution(s2)); // Output: 5

        System.out.println("--------------------");

        // Example 3: S = "aabbbabaaa" -> Expected output: 3
        String s3 = "aabbbabaaa";
        System.out.println("Input: " + s3);
        System.out.println("Shortest unique substring length: " + sol.solution(s3)); // Output: 3
    }
}
