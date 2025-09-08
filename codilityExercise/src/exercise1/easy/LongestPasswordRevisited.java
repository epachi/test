package exercise1.easy;
//You would like to set a password for a bank account. However, there are three restrictions on the format of the password:
//
//        it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
//        there should be an even number of letters;
//        there should be an odd number of digits.
//        You are given a string S consisting of N characters. String S can be divided into words by splitting it at, and removing, the spaces.
//        The goal is to choose the longest word that is a valid password.
//        You can assume that if there are K spaces in string S then there are exactly K + 1 words.
//
//        For example, given "test 5 a0A pass007 ?xy1", there are five words and three of them are valid passwords: "5", "a0A" and "pass007".
//        Thus the longest password is "pass007" and its length is 7. Note that neither "test" nor "?xy1" is a valid password,
//        because "?" is not an alphanumerical character and "test" contains an even number of digits (zero).
//
//        Write a function:
//
//              public int solution(String S)
//
//        that, given a non-empty string S consisting of N characters, returns the length of the longest word from the string that is a valid password. If there is no such word, your function should return −1.
//
//        For example, given S = "test 5 a0A pass007 ?xy1", your function should return 7, as explained above.
//
//        Assume that:
//
//        N is an integer within the range [1..200];
//        string S consists only of printable ASCII characters and spaces.
//        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
public class LongestPasswordRevisited {
    public int solution(String S) {
        int longestPasswordLength = -1;

        // Split the string into words
        String[] words = S.split("\\s+");       //<===================S.split(

        for (String word : words) {
            if (isValidPassword(word)) {
                int currentLength = word.length();
                longestPasswordLength = Math.max(longestPasswordLength, currentLength);
            }
        }

        return longestPasswordLength;
    }

    private boolean isValidPassword(String password) {
        int letterCount = 0;
        int digitCount = 0;

        for (char ch : password.toCharArray()) {                    //<== password.toCharArray()
            if (Character.isLetter(ch)) {                           //<== Character.isLetter(ch)
                letterCount++;
            } else if (Character.isDigit(ch)) {                     //<== Character.isDigit(ch)
                digitCount++;
            } else {
                // Non-alphanumeric character, invalid password
                return false;
            }
        }

        // Check if there is an even number of letters and an odd number of digits
        return letterCount % 2 == 0 && digitCount % 2 != 0;
    }

    public static void main(String[] args) {
        LongestPasswordRevisited passwordSolution = new LongestPasswordRevisited();
        String input = "test 5 a0A pass007 ?xy1";
        int result = passwordSolution.solution(input);
        System.out.println(result); // Output: 7
    }
}
