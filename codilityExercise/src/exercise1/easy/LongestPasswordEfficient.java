package exercise1.easy;
public class LongestPasswordEfficient {
    public int solution(String S) {
        int longestPasswordLength = -1;
        int currentWordLength = 0;
        int letterCount = 0;
        int digitCount = 0;
        boolean skipInvalid = false;

        for (char ch : S.toCharArray()) {
            System.out.println("new ch is:" + ch);
            if (skipInvalid && ch != ' ') {
                    continue;
            }
            if (ch == ' ') {
                // Check if the current word is a valid password
                if (isValidPassword(letterCount, digitCount)) {
                    longestPasswordLength = Math.max(longestPasswordLength, currentWordLength);
                    System.out.println("Longest pl:" + longestPasswordLength);
                }

                // Reset counts for the next word
                currentWordLength = 0;
                letterCount = 0;
                digitCount = 0;
            } else {
                // Update counts for the current word
                currentWordLength++;
                if (Character.isLetter(ch)) {                       // <==== Character.isLetter
                    letterCount++;
                } else if (Character.isDigit(ch)) {                  // <==== Character.isDigit
                    digitCount++;
                } else {
                    // Non-alphanumeric character, invalid password
//                    return -1;
                    skipInvalid = true;
                }
                System.out.println("[ch]:"+ String.valueOf(ch) + " ,[letterCount]:"+letterCount+", [digitCount]: " +digitCount);
            }
        }

        // Check the last word in the string
        if (isValidPassword( letterCount, digitCount)) {
            longestPasswordLength = Math.max(longestPasswordLength, currentWordLength);
            System.out.println("Password encounted: [currentWordLength]:"+currentWordLength+", [longestPasswordLength]:"+longestPasswordLength);
        }

        return longestPasswordLength;
    }

    private boolean isValidPassword(int letterCount, int digitCount) {
        // Check if the current word is a valid password
        boolean validPassword = letterCount % 2 == 0 && digitCount % 2 != 0;
        System.out.println("**Valid Password**?" + validPassword);
        return validPassword;
    }

    public static void main(String[] args) {
        LongestPasswordEfficient passwordSolution = new LongestPasswordEfficient();
        String input = "test 5 a0A pass007 ?xy1";
        int result = passwordSolution.solution(input);
        System.out.println(result); // Output: 7
    }
}

//    This optimized implementation eliminates the need for creating an array of words and reduces the number of iterations, resulting in a more efficient solution.