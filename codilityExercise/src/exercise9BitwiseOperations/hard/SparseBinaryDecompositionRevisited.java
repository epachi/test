package exercise9BitwiseOperations.hard;
//Decompose int into sum of ints having no consecutive 1s in binary form.
//
//A non-negative integer N is called sparse if its binary representation does not contain two consecutive bits set to 1.
// For example, 41 is sparse, because its binary representation is "101001" and it does not contain two consecutive 1s.
// On the other hand, 26 is not sparse, because its binary representation is "11010" and it contains two consecutive 1s.
//
//        Two non-negative integers P and Q are called a sparse decomposition of integer N if P and Q are sparse and N = P + Q.
//
//        For example:
//
//        8 and 18 are a sparse decomposition of 26 (binary representation of 8 is "1000", binary representation of 18 is "10010");
//        9 and 17 are a sparse decomposition of 26 (binary representation of 9 is "1001", binary representation of 17 is "10001");
//        2 and 24 are not a sparse decomposition of 26; though 2 + 24 = 26, the binary representation of 24 is "11000", which is not sparse.
//        Write a function:
//
//class Solution { public int solution(int N); }
//
//that, given a non-negative integer N, returns any integer that is one part of a sparse decomposition of N.
// The function should return −1 if there is no sparse decomposition of N.
//
//        For example, given N = 26 the function may return 8, 9, 17 or 18, as explained in the example above.
//        All other possible results for N = 26 are 5, 10, 16 and 21.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..1,000,000,000].



public class SparseBinaryDecompositionRevisited {
    public int solution(int N) {
        // Special case: if N is 0, the only decomposition is 0 + 0
        if (N == 0) {
            return 0;
        }

        // Try all possible values of P from 0 to N/2
        // We only need to check up to N/2 since if (P, Q) is a solution,
        // then (Q, P) is also a solution
        for (int P = 0; P <= N / 2; P++) {
            int Q = N - P;

            // Check if both P and Q are sparse
            if (isSparse(P) && isSparse(Q)) {
                return P;
            }
        }

        // No sparse decomposition found
        return -1;
    }

    /**
     * Checks if a number is sparse (no consecutive 1s in binary representation)
     */
    private boolean isSparse(int num) {                 //<===== How to determine a number is sparse
        // A number is sparse if (num & (num << 1)) == 0
        // This works because:
        // - num << 1 shifts all bits left by 1 position
        // - If there are consecutive 1s, the AND operation will result in non-zero
        // - If there are no consecutive 1s, the AND operation will result in 0
        return (num & (num << 1)) == 0;
    }

    public static void main(String[] args) {
        SparseBinaryDecompositionRevisited solution = new SparseBinaryDecompositionRevisited();
        System.out.println(solution.solution(26));

        // Test case 2: N = 0
        int result0 = solution.solution(0);
        System.out.println("\nN = 0, result = " + result0);

        // Test case 3: N = 1
        int result1 = solution.solution(1);
        System.out.println("\nN = 1, result = " + result1);
        if (result1 != -1) {
            int other = 1 - result1;
            System.out.println("  Decomposition: " + result1 + " + " + other + " = 1");
        }

        // Test case 4: N = 8
        int result8 = solution.solution(8);
        System.out.println("\nN = 8, result = " + result8);
        if (result8 != -1) {
            int other = 8 - result8;
            System.out.println("  Decomposition: " + result8 + " + " + other + " = 8");
            System.out.println("  " + result8 + " binary: " + Integer.toBinaryString(result8));
            System.out.println("  " + other + " binary: " + Integer.toBinaryString(other));
        }

        // Test sparse checker function
        System.out.println("\nTesting sparse checker:");
        int[] testNumbers = {0, 1, 2, 3, 4, 5, 8, 9, 10, 16, 17, 18, 24, 26, 41};
        for (int num : testNumbers) {
            boolean sparse = (num & (num << 1)) == 0;
            System.out.println(num + " (" + Integer.toBinaryString(num) + ") is " +
                    (sparse ? "sparse" : "not sparse"));
        }

    }
}

//In this implementation, the solution function iterates through the bits of the binary representation of N and checks for consecutive 1s. If found, it flips one of them to 0 and checks if the resulting number is sparse using the isSparse function. If a sparse decomposition is found, it returns one of the numbers in the decomposition; otherwise, it returns -1.
//
//        The isSparse function checks if a given number is sparse by iterating through its bits and checking for consecutive 1s. If consecutive 1s are found, the function returns false; otherwise, it returns true.
//
//        This algorithm has a time complexity of O(log N) due to the conversion to binary representation, and the space complexity is O(1).