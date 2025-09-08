package exercise5CodingSkills.medium;

//The current solution is relatively simple and straightforward,
//        but it may not be the most efficient one. We can optimize it by reducing the number of iterations in the loop.
//        Instead of checking the last two characters of the result string in each iteration,
//        we can maintain separate counters for consecutive 'a' and 'b' characters.
public class ThreeLettersEfficientWrong {
    public static String solution(int A, int B) {
        StringBuilder result = new StringBuilder();
        int consecutiveA = 0;
        int consecutiveB = 0;

        while (A > 0 || B > 0) {
            // Append 'a' if A > B and consecutiveA < 2
            if (A > B && consecutiveA < 2) {
                result.append("a");
                A--;
                consecutiveA++;
                consecutiveB = 0;
            } else if (B > 0 && consecutiveB < 2) {
                // Append 'b' if B > 0 and consecutiveB < 2
                result.append("b");
                B--;
                consecutiveB++;
                consecutiveA = 0;
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

//    This optimization eliminates the need to check the last two characters in each iteration, making the solution more efficient.
//        It uses separate counters to keep track of consecutive 'a' and 'b' characters and ensures that no three consecutive letters are the same.