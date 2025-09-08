package exercise5CodingSkills.easy;

//The time complexity of the provided solution is O(log N) because it depends on the number of trailing zeros in the binary representation of N.
//        However, you can optimize the solution by using bitwise operations more efficiently. Here's an updated version:
public class ParityDegreeEfficient {
    public int solution(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be a positive integer");
        }

        // Count the number of trailing zeros using a bitwise operation
        return Integer.numberOfTrailingZeros(N);
    }

    public static void main(String[] args) {
        ParityDegreeEfficient solution = new ParityDegreeEfficient();
        System.out.println(solution.solution(24)); // Output: 3
        System.out.println(solution.solution(32)); // Output: 5
        System.out.println(solution.solution(7));  // Output: 0
    }
}
//In this version, the solution method utilizes Integer.numberOfTrailingZeros directly, which is a built-in Java method optimized
//        or counting the number of trailing zeros. This should provide better performance compared to the manual bitwise shift operation,
//        especially for large values of N. The time complexity is still O(1) since the number of trailing zeros can be determined in constant time.