package codilityQ4;

//A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
//        Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
//        A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
//        The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) – (A[P] + A[P + 1] + ... + A[N − 1])|
//        In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
//        For example, consider array A such that:
//        A[0] = 3
//        A[1] = 1
//        A[2] = 2
//        A[3] = 4
//        A[4] = 3
//        We can split this tape in four places:
//        * P = 1, difference = |3 - 10|= 7
//        * P = 2, difference = |4 - 9| = 5
//        * P = 3, difference = |6 - 7|= 1
//        * P = 4, difference = |10 - 3| = 7
//        Write a Java function:
//        int solution (int [] A);
//        that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
//        For example, given:
//        A[0] = 3
//        A[1] = 1
//        A[2] = 2
//        A[3] = 4
//        A[4] = 3
//        the function should return 1, as explained above.
//        Write an efficient algorithm for the following assumptions:
//        • N is an integer within the range [2..100,000];
//        • each element of array A is an integer within the range [-1,000..1,000].

public class TapeEquilibrium {

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3};
        int result = solution(A);
        System.out.println("Minimal difference: " + result);
    }

    public static int solution(int[] A) {
        int N = A.length;

        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int leftSum = 0;
        int rightSum = totalSum;
        int minimalDifference = Integer.MAX_VALUE;

        // Iterate through each possible split point P
        for (int P = 1; P < N; P++) {
            leftSum += A[P - 1];
            rightSum -= A[P - 1];

            // Calculate the absolute difference for the current split point
            int currentDifference = Math.abs(leftSum - rightSum);           //<====Math.abs(leftSum - rightSum)

            // Update the minimal difference
            minimalDifference = Math.min(minimalDifference, currentDifference);
        }

        return minimalDifference;
    }
}

//    This solution maintains two variables, leftSum and rightSum, which represent the sums of the left and right parts of the split.
//        It iterates through each possible split point and calculates the absolute difference for each split.
//        The minimalDifference variable keeps track of the minimum difference encountered during the iteration.
//
//        The time complexity of this solution is O(N), where N is the length of the array.
//        The space complexity is O(1) as we only use a constant amount of extra space.