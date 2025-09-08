package exercise7DataStructure.mediumToBeFixed;
//Calculate the number of slices in which (maximum - minimum <= K).

//An integer K and a non-empty array A consisting of N integers are given.
//
//        A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
//
//        A bounded slice is a slice in which the difference between the maximum and minimum values in the slice is less than
//        or equal to K. More precisely it is a slice, such that max(A[P], A[P + 1], ..., A[Q]) − min(A[P], A[P + 1], ..., A[Q]) ≤ K.
//
//        The goal is to calculate the number of bounded slices.
//
//        For example, consider K = 2 and array A such that:
//
//        A[0] = 3
//        A[1] = 5
//        A[2] = 7
//        A[3] = 6
//        A[4] = 3
//        There are exactly nine bounded slices: (0, 0), (0, 1), (1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (3, 3), (4, 4).
//
//        Write a function:
//
//class Solution { public int solution(int K, int[] A); }
//
//that, given an integer K and a non-empty array A of N integers, returns the number of bounded slices of array A.
//
//        If the number of bounded slices is greater than 1,000,000,000, the function should return 1,000,000,000.
//
//        For example, given:
//
//        A[0] = 3
//        A[1] = 5
//        A[2] = 7
//        A[3] = 6
//        A[4] = 3
//        the function should return 9, as explained above.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        K is an integer within the range [0..1,000,000,000];
//        each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
public class CountBoundedSlicesRevisited {
    public int solution(int K, int[] A) {
        int count = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < A.length; i++) {
            max = A[i];
            min = A[i];
            for (int j = i ; j < A.length; j++) {
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
                if (max - min <= K) {
                    System.out.println("i:"+i+", j:"+ j+", max:"+max+", min:"+min);
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;


//        int N = A.length;
//        int result = 0;
//        int front = 0;
//
//        for (int back = 0; back < N; back++) {
//            while (front < N && Math.abs(A[front] - A[back]) <= K) {
//                front++;
//            }
//            result += front - back;
//
//            if (result > 1_000_000_000) {
//                return 1_000_000_000;
//            }
//        }
//
//        return result;
    }


    public static void main(String[] args) {
        CountBoundedSlicesRevisited solution = new CountBoundedSlicesRevisited();
        int [] A = {3, 5, 7, 6, 3};
        System.out.println(solution.solution(2, A)); // Output: 9

    }
}
//    This solution uses a two-pointer approach (front and back) to efficiently count the number of bounded slices.
//        The key idea is to expand the front pointer as long as the difference between the maximum and minimum values in the slice is less than or equal to K.
//        The number of slices is then calculated and added to the result.
//
//        The algorithm runs in O(N) time complexity, where N is the length of the input array A.
//        The result is capped at 1,000,000,000 as specified in the problem statement.
