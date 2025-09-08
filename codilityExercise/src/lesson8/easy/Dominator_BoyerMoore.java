package lesson8.easy;

//An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
//
//For example, consider array A such that
//
// A[0] = 3    A[1] = 4    A[2] =  3
// A[3] = 2    A[4] = 3    A[5] = -1
// A[6] = 3    A[7] = 3
//The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
//
//Write a function
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs.
// The function should return −1 if array A does not have a dominator.
//
//For example, given array A such that
//
// A[0] = 3    A[1] = 4    A[2] =  3
// A[3] = 2    A[4] = 3    A[5] = -1
// A[6] = 3    A[7] = 3
//the function may return 0, 2, 4, 6 or 7, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..100,000];
//each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

//To solve this problem efficiently, we can use the "Boyer-Moore Voting Algorithm."
// This algorithm allows us to find the majority element (if it exists) in a single pass with constant space.
public class Dominator_BoyerMoore {
    public int solution(int[] A) {
        int candidate = -1;
        int count = 0;

        // Find a candidate for the dominator
        for (int i = 0; i < A.length; i++) {
            if (count == 0) {
                candidate = A[i];
                count++;
            } else {
                if (A[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        // Check if the candidate is a dominator
        count = 0;
        int candidateIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
                candidateIndex = i;
            }
        }

        // Check if the candidate occurs in more than half of the elements
        return (count > A.length / 2) ? candidateIndex : -1;
    }
}

//The algorithm consists of two phases:
//
//Finding the candidate for the dominator: Iterate through the array, and maintain a candidate for the dominator along with a count.
// If the count becomes zero, update the candidate. If the current element is the same as the candidate, increment the count; otherwise, decrement the count.
//
//Checking if the candidate is a dominator: Iterate through the array again to count the occurrences of the candidate.
// If the count is greater than half of the array length, return the index of the candidate; otherwise, return -1.
//
//This algorithm runs in O(N) time complexity and O(1) space complexity, making it efficient for large arrays.