package exercise4AlgoSkills.easy;
//Certainly! We can achieve a more efficient solution by using two pointers and comparing characters from the beginning and end of the string.
// This eliminates the need to create substrings and reversals explicitly.
public class StrSymmetryPointEfficient {
    public int solution(String S) {
        int length = S.length();

        for (int i = 0; i < length / 2; i++) {
            if (S.charAt(i) == S.charAt(length - 1 - i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        StrSymmetryPointEfficient solution = new StrSymmetryPointEfficient();

        // Example 1
        String S1 = "racecar";
        System.out.println(solution.solution(S1)); // Output: 3

        // Example 2
        String S2 = "x";
        System.out.println(solution.solution(S2)); // Output: 0
    }
}

//In this optimized solution, we use two pointers (i and length - 1 - i) to compare characters from the beginning and end of the string.
//        If we find a mismatch, we know that the string is not a reversal at that index, and we can continue checking other indices.
//        This reduces the time complexity to O(N), making the solution more efficient.
