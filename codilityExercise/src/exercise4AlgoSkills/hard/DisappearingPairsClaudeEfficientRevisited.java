package exercise4AlgoSkills.hard;
//import java.util.Stack;
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

//To solve this problem, you can iterate through the input string and repeatedly remove occurrences of "AA", "BB", or "CC"
//        until no more transformations can be made. Here's a Java implementation:
public class DisappearingPairsClaudeEfficientRevisited {
    public String solution(String S) {
        // Use StringBuilder as a stack for efficiency
        StringBuilder stack = new StringBuilder();

        for (char c : S.toCharArray()) {
            // If stack is not empty and top character equals current character
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
                // Remove the pair by popping the top character
                stack.deleteCharAt(stack.length() - 1);             //<=== (StingBuilder) stack.deleteCharAt
                                                                          // Use a real Stack may be easier

            } else {
                // Push current character onto stack
                stack.append(c);
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        DisappearingPairsClaudeEfficientRevisited solution = new DisappearingPairsClaudeEfficientRevisited();

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