package MoreTest;

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

public class TestQuestion1 {    /**
 * Given a string S, this function returns the length of the shortest substring
 * that occurs in S exactly once.
 *
 * @param S The input string, consisting of lowercase letters 'a'-'z'.
 * @return The length of the shortest unique substring.
 */
public int solution(String S) {return 0;

}

    /**
     * Main method for testing the solution with the provided examples.
     */
    public static void main(String[] args) {
        TestQuestion1 sol = new TestQuestion1();

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
