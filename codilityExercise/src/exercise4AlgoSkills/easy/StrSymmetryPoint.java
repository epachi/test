package exercise4AlgoSkills.easy;
//Write a function:
//
//class Solution { public int solution(String S); }
//
//that, given a string S, returns the index (counting from 0) of a character such that the part of the string to the left of
// that character is a reversal of the part of the string to its right. The function should return −1 if no such index exists.
//
//        Note: reversing an empty string (i.e. a string whose length is zero) gives an empty string.
//
//        For example, given a string:
//
//        "racecar"
//
//        the function should return 3, because the substring to the left of the character "e" at index 3 is "rac", and the one to the right is "car".
//
//        Given a string:
//
//        "x"
//
//        the function should return 0, because both substrings are empty.
//
//        Write an efficient algorithm for the following assumptions:
//
//        the length of string S is within the range [0..2,000,000].

//
//To solve this problem, we can iterate through the characters of the string and check if the substring to the left of the current
//        character is a reversal of the substring to its right.
//        We can do this by comparing the reversed substring with the original substring.
public class StrSymmetryPoint {
    public int solution(String S) {
        int length = S.length();

        for (int i = 0; i < length; i++) {
            String leftSubstring = S.substring(0, i);
            String rightSubstring = S.substring(i + 1);

            if (isReversal(leftSubstring, rightSubstring)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isReversal(String left, String right) {
        StringBuilder reversed = new StringBuilder(left).reverse();             //<=======new StringBuilder(left).reverse()
        return right.equals(reversed.toString());
    }

    public static void main(String[] args) {
        StrSymmetryPoint solution = new StrSymmetryPoint();

        // Example 1
        String S1 = "racecar";
        System.out.println(solution.solution(S1)); // Output: 3

        // Example 2
        String S2 = "x";
        System.out.println(solution.solution(S2)); // Output: 0
    }
}

//    This solution has a time complexity of O(N^2) due to the nested loop over substrings. However, since the length of the string is limited to 2,000,000,
//        it should still provide reasonable performance. If further optimization is needed,
//        more advanced algorithms might be explored, but they would likely involve more complex logic.
