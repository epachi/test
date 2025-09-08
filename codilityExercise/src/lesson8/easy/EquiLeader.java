package lesson8.easy;

//A non-empty array A consisting of N integers is given.
//
//The leader of this array is the value that occurs in more than half of the elements of A.
//
//An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
//
//For example, given array A such that:
//
//    A[0] = 4
//    A[1] = 3
//    A[2] = 4
//    A[3] = 4
//    A[4] = 4
//    A[5] = 2
//we can find two equi leaders:
//
//0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
//2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
//The goal is to count the number of equi leaders.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
//
//For example, given:
//
//    A[0] = 4
//    A[1] = 3
//    A[2] = 4
//    A[3] = 4
//    A[4] = 4
//    A[5] = 2
//the function should return 2, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].



//////////////// SOLUTIION 1 //////////////// SOLUTIION 1
public class EquiLeader {
    public int solution(int[] A) {
        int candidate = -1;
        int count = 0;

        // Find a candidate for the leader
        for (int num : A) {
            if (count == 0) {
                candidate = num;
                count++;
            } else {
                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        // Check if the candidate is a leader
        count = 0;
        for (int num : A) {
            if (num == candidate) {
                count++;
            }
        }

        // Check if the candidate is a leader
        if (count <= A.length / 2) {
            return 0;
        }

        // Count the equi leaders
        int equiLeaderCount = 0;
        int leftLeaderCount = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == candidate) {
                leftLeaderCount++;
            }

            int rightLeaderCount = count - leftLeaderCount;

            if (leftLeaderCount > (i + 1) / 2 && rightLeaderCount > (A.length - 1 - i) / 2) {
                equiLeaderCount++;
            }
        }

        return equiLeaderCount;
    }
}
//The algorithm first finds a potential leader using the Boyer-Moore Majority Vote algorithm.
// It then checks if the candidate is a leader by counting its occurrences in the array. Finally, it iterates through the array to count the number of equi leaders by considering both the left and right subarrays.
//
//The time complexity of this algorithm is O(N), where N is the length of the input array.
// The space complexity is O(1), as we only use a constant amount of extra space.


//////////////// SOLUTIION 2 //////////////// SOLUTIION 2
//To solve this problem efficiently, we can use the Boyer-Moore Voting Algorithm to find the candidate for the leader.
//        After finding the candidate leader, we iterate through the array again to count its occurrences.
//        For each position, we check if the leader of the prefix sequence and the leader of the suffix sequence are the same.

//class Solution {
//    public int solution(int[] A) {
//        int candidate = -1;
//        int count = 0;
//
//        // Find the candidate for the leader
//        for (int i = 0; i < A.length; i++) {
//            if (count == 0) {
//                candidate = A[i];
//                count++;
//            } else {
//                if (A[i] == candidate) {
//                    count++;
//                } else {
//                    count--;
//                }
//            }
//        }
//
//        // Count occurrences of the candidate leader
//        int leaderCount = 0;
//        for (int value : A) {
//            if (value == candidate) {
//                leaderCount++;
//            }
//        }
//
//        // Check if the candidate is a leader
//        if (leaderCount <= A.length / 2) {
//            return 0; // No leader
//        }
//
//        int equiLeaders = 0;
//        int leftLeaderCount = 0;
//        int rightLeaderCount = leaderCount;
//
//        // Check equi leaders for each position
//        for (int i = 0; i < A.length - 1; i++) {
//            if (A[i] == candidate) {
//                leftLeaderCount++;
//                rightLeaderCount--;
//            }
//
//            if (leftLeaderCount > (i + 1) / 2 && rightLeaderCount > (A.length - i - 1) / 2) {
//                equiLeaders++;
//            }
//        }
//
//        return equiLeaders;
//    }
//}

//This solution has a time complexity of O(N) and a space complexity of O(1).
// The algorithm first finds the candidate leader using the Boyer-Moore Voting Algorithm, then checks for equi leaders by iterating through the array.
// The counts of leaders for the left and right parts are updated at each position to check for equi leaders efficiently.