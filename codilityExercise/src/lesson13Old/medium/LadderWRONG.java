package lesson13Old.medium;

//You have to climb up a ladder. The ladder has exactly N rungs, numbered from 1 to N. With each step, you can ascend by one or two rungs. More precisely:
//
//with your first step you can stand on rung 1 or 2,
//if you are on rung K, you can move to rungs K + 1 or K + 2,
//finally you have to stand on rung N.
//Your task is to count the number of different ways of climbing to the top of the ladder.
//
//For example, given N = 4, you have five different ways of climbing, ascending by:
//
//1, 1, 1 and 1 rung,
//1, 1 and 2 rungs,
//1, 2 and 1 rung,
//2, 1 and 1 rungs, and
//2 and 2 rungs.
//Given N = 5, you have eight different ways of climbing, ascending by:
//
//1, 1, 1, 1 and 1 rung,
//1, 1, 1 and 2 rungs,
//1, 1, 2 and 1 rung,
//1, 2, 1 and 1 rung,
//1, 2 and 2 rungs,
//2, 1, 1 and 1 rungs,
//2, 1 and 2 rungs, and
//2, 2 and 1 rung.
//The number of different ways can be very large, so it is sufficient to return the result modulo 2P, for a given integer P.
//
//Write a function:
//
//class Solution { public int[] solution(int[] A, int[] B); }
//
//that, given two non-empty arrays A and B of L integers, returns an array consisting of L integers specifying the consecutive answers; position I should contain the number of different ways of climbing the ladder with A[I] rungs modulo 2B[I].
//
//For example, given L = 5 and:
//
//    A[0] = 4   B[0] = 3
//    A[1] = 4   B[1] = 2
//    A[2] = 5   B[2] = 4
//    A[3] = 5   B[3] = 3
//    A[4] = 1   B[4] = 1
//the function should return the sequence [5, 1, 8, 0, 1], as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//L is an integer within the range [1..50,000];
//each element of array A is an integer within the range [1..L];
//each element of array B is an integer within the range [1..30].

class LadderWRONG {
    public int[] solution(int[] A, int[] B) {
        int maxRungs = 0;
        for (int i = 0; i < A.length; i++) {
            maxRungs = Math.max(maxRungs, A[i]);
        }

        // Compute the Fibonacci numbers up to the maximum number of rungs
        int[] fibonacci = calculateFibonacci(maxRungs + 2);

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            // Calculate the number of ways using Fibonacci property (sum of previous two numbers)
            result[i] = fibonacci[A[i] + 1] % (1 << B[i]);
        }

        return result;
    }

    // Helper method to calculate Fibonacci numbers
    private int[] calculateFibonacci(int n) {
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % (1 << 30);
        }

        return fibonacci;
    }

    public static void main(String[] args) {
        LadderWRONG solution = new LadderWRONG();
        int [] A = {4, 4, 5, 5, 1};
        int [] B = {3, 2, 4, 3, 1};

        int [] modCount = solution.solution(A, B);
        for (int i = 0 ; i < modCount.length ; i++) {
            System.out.println("==>" + modCount[i]);

        }
    }
}
//    This solution calculates the Fibonacci numbers up to the maximum number of rungs in the given set of queries.
//        It then uses the Fibonacci property to efficiently compute the number of ways for each query.
//        The results are stored in the result array and returned.
//        The modulo operation is applied to avoid overflow, and the bitwise shift (1 << B[i]) is used to compute the modulo 2^B[i].