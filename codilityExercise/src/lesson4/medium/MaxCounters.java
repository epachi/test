package lesson4.medium;

//You are given N counters, initially set to 0, and you have two possible operations on them:
//
//        increase(X) − counter X is increased by 1,
//        max counter − all counters are set to the maximum value of any counter.
//        A non-empty array A of M integers is given. This array represents consecutive operations:
//
//        if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
//        if A[K] = N + 1 then operation K is max counter.
//        For example, given integer N = 5 and array A such that:
//
//        A[0] = 3
//        A[1] = 4
//        A[2] = 4
//        A[3] = 6
//        A[4] = 1
//        A[5] = 4
//        A[6] = 4
//        the values of the counters after each consecutive operation will be:
//
//        (0, 0, 1, 0, 0)
//        (0, 0, 1, 1, 0)
//        (0, 0, 1, 2, 0)
//        (2, 2, 2, 2, 2)
//        (3, 2, 2, 2, 2)
//        (3, 2, 2, 3, 2)
//        (3, 2, 2, 4, 2)
//        The goal is to calculate the value of every counter after all operations.
//
//        Write a function:
//
//class Solution { public int[] solution(int N, int[] A); }
//
//that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
//
//        Result array should be returned as an array of integers.
//
//        For example, given:
//
//        A[0] = 3
//        A[1] = 4
//        A[2] = 4
//        A[3] = 6
//        A[4] = 1
//        A[5] = 4
//        A[6] = 4
//        the function should return [3, 2, 2, 4, 2], as explained above.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N and M are integers within the range [1..100,000];
//        each element of array A is an integer within the range [1..N + 1].
public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int lastMaxCounter = 0;

        for (int value : A) {
            if (value >= 1 && value <= N) {
                // Increase operation
                if (counters[value - 1] < lastMaxCounter) {
                    counters[value - 1] = lastMaxCounter + 1;
                } else {
                    counters[value - 1]++;
                }

                // Update maxCounter
                maxCounter = Math.max(maxCounter, counters[value - 1]);
            } else if (value == N + 1) {
                // Max counter operation
                lastMaxCounter = maxCounter;
            }
        }

        // Update counters that haven't been updated after the last max counter operation
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < lastMaxCounter) {
                counters[i] = lastMaxCounter;
            }
        }

        return counters;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int [] result = (new MaxCounters()).solution(N, A);
        for (int i = 0 ; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.println("\n");
    }

//    This solution iterates through the array A and performs the specified operations on counters.
//    It maintains two variables: maxCounter to track the maximum counter value, and lastMaxCounter to record the maximum counter value
//    after the last max counter operation. It then updates the counters accordingly.
//
//    The time complexity of this solution is O(N + M), where N is the length of the counters array and M is the length of array A.
}