package exercise5CodingSkills.medium;

//Write a function solution that, given two integers A and B, returns a string containing exactly A letters
// 'a' and exactly B letters 'b' with no three consecutive letters being the same
// (in other words, neither "aaa" nor "bbb" may occur in the returned string).
//
//        Examples:
//
//        1. Given A = 5 and B = 3, your function may return "aabaabab". Note that "abaabbaa" would also be a correct answer.
//        Your function may return any correct answer.
//
//        2. Given A = 3 and B = 3, your function should return "ababab", "aababb", "abaabb" or any of several other strings.
//
//        3. Given A = 1 and B = 4, your function should return "bbabb", which is the only correct answer in this case.
//
//        Assume that:
//
//        A and B are integers within the range [0..100];
//        at least one solution exists for the given A and B.
//        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
public class ThreeLettersWrong {
    public static String solution(int A, int B) {
        StringBuilder result = new StringBuilder();                 //<======StringBuilder result = new StringBuilder();

        while (A > 0 || B > 0) {
            // Append 'a' if A > B and the last two characters are not 'aa'
            if (A > B && (result.length() < 2 || !result.substring(result.length() - 2).equals("aa"))) {
                result.append("a");
                A--;
            } else if (B > 0) {
                // Append 'b' if B > 0 and the last two characters are not 'bb'
                result.append("b");
                B--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 3)); // Example 1
        System.out.println(solution(3, 3)); // Example 2
        System.out.println(solution(1, 4)); // Example 3
    }
}
//    This solution builds the result string iteratively while ensuring that no three consecutive letters are the same.
//        It appends 'a' if A is greater than B and the last two characters are not 'aa', and it appends 'b' otherwise.
//        The loop continues until both A and B are exhausted. The solution prints some example cases in the main method.