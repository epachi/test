package lesson9.Easy;
//A non-empty array A consisting of N integers is given. A pair of integers (P, Q),
// such that 0 ≤ P ≤ Q < N, is called a slice of array A.
// The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
//
//For example, given array A such that:
//
//A[0] = 3  A[1] = 2  A[2] = -6
//A[3] = 4  A[4] = 0
//the function should return 5 because:
//
//(3, 4) is a slice of A that has sum 4,
//(2, 2) is a slice of A that has sum −6,
//(0, 1) is a slice of A that has sum 5,
//no other slice of A has sum greater than (0, 1).
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..1,000,000];
//each element of array A is an integer within the range [−1,000,000..1,000,000];
//the result will be an integer within the range [−2,147,483,648..2,147,483,647].

//To find the maximum sum of any slice in an array,
// we can use Kadane's algorithm, which is an efficient linear-time algorithm.

//See https://www.youtube.com/watch?v=NUWAXbSlsws
//Alternatively, can have the following algorithm. Increase from index to right and calculate partial sum until come across a negative number and
// reset the loop....


public class MaxSliceSum_KadaneRevisited {
    public int solution(int[] A) {
        int maxEndingHere = A[0];
        int maxSoFar = A[0];
        //Traverse the array from the second element
        for (int i = 1; i < A.length; i++) {
            // If current Sum is negative, reset to the current element
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            // Update maxSum if current Sum is greater
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSliceSum_KadaneRevisited solution = new MaxSliceSum_KadaneRevisited();
        int [] A = {3, 2, -6, 4, 0};
        System.out.println(solution.solution(A));
    }
}
//This algorithm maintains two variables: maxEndingHere and maxSoFar.
// It iterates through the array and updates these variables based on the current element.
// The maxEndingHere variable represents the maximum sum ending at the current position,
// and maxSoFar represents the maximum sum encountered so far.
//
//The time complexity of this algorithm is O(N), where N is the length of the input array,
// as it makes a single pass through the array.
// The space complexity is O(1) since it uses only a constant amount of additional space.