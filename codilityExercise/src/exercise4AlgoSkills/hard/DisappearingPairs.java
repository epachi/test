package exercise4AlgoSkills.hard;
//
//A string S containing only the letters "A", "B" and "C" is given. The string can be transformed by removing one occurrence of "AA", "BB" or "CC".
//
//        Transformation of the string is the process of removing letters from it, based on the rules described above. As long as at least one rule can be applied, the process should be repeated. If more than one rule can be used, any one of them could be chosen.
//
//        Write a function:
//
//class Solution { public String solution(String S); }
//
//that, given a string S consisting of N characters, returns any string that can result from a sequence of transformations as described above.
//
//        For example, given string S = "ACCAABBC" the function may return "AC", because one of the possible sequences of transformations is as follows:
//
//
//
//        Also, given string S = "ABCBBCBA" the function may return "", because one possible sequence of transformations is:
//
//
//
//        Finally, for string S = "BABABA" the function must return "BABABA", because no rules can be applied to string S.
//
//        Write an efficient algorithm for the following assumptions:
//
//        the length of string S is within the range [0..50,000];
//        string S is made only of the following characters: 'A', 'B' and/or 'C'.

import java.util.Stack;

//To solve this problem, you can iterate through the input string and repeatedly remove occurrences of "AA", "BB", or "CC"
//        until no more transformations can be made. Here's a Java implementation:
public class DisappearingPairs {
    public String solution(String S) {
        StringBuilder sb = new StringBuilder(S);            //<==== StringBuilder

        boolean transformed;
        do {
            transformed = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);                   //<==== sb.delete(i, i + 2);
                    transformed = true;
                    break;
                }
            }
        } while (transformed);

        return sb.toString();
    }

    public static void main(String[] args) {
        DisappearingPairs solution = new DisappearingPairs();

        String S1 = "ACCAABBC";
        System.out.println(solution.solution(S1)); // Output: "AC"

        String S2 = "ABCBBCBA";
        System.out.println(solution.solution(S2)); // Output: ""

        String S3 = "BABABA";
        System.out.println(solution.solution(S3)); // Output: "BABABA"
    }
}
//
//    This solution uses a StringBuilder to efficiently modify the string while iterating through it.
//        The algorithm repeatedly looks for adjacent equal characters and removes them until no more transformations can be made.
//
//        Please note that there might be multiple valid solutions for a given input string, and this implementation returns one possible result.