package exercise4AlgoSkills.hard;
//The provided solution is already quite efficient, and the time complexity of the algorithm is O(N^2) in the worst case,
//        where N is the length of the input string.
//        This is because, in the worst case, we might need to iterate through the entire string in each iteration of the do-while loop.
//
//        It's unlikely to significantly improve the time complexity since any algorithm solving this problem will inherently
//        have a worst-case time complexity of O(N^2), as we need to check for and remove adjacent duplicates repeatedly.
//
//        However, you can make a small improvement in terms of code simplicity and readability by using a while loop instead of a do-while loop,
//        as the do-while loop is typically used when you want to guarantee at least one iteration. In this case,
//        a while loop with a flag can serve the same purpose. Here's a modified version:
public class DisappearingPairsEfficient {
    public String solution(String S) {
        StringBuilder sb = new StringBuilder(S);

        boolean transformed = true;
        while (transformed) {
            transformed = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    transformed = true;
                    break;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DisappearingPairsEfficient solution = new DisappearingPairsEfficient();

        String S1 = "ACCAABBC";
        System.out.println(solution.solution(S1)); // Output: "AC"

        String S2 = "ABCBBCBA";
        System.out.println(solution.solution(S2)); // Output: ""

        String S3 = "BABABA";
        System.out.println(solution.solution(S3)); // Output: "BABABA"
    }
}
//    This modification makes the termination condition clearer and maintains the efficiency of the algorithm.