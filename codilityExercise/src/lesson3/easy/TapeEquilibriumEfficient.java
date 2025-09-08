package lesson3.easy;

//A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
//
//Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
//
//The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
//
//In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
//
//For example, consider array A such that:
//
//  A[0] = 3
//  A[1] = 1
//  A[2] = 2
//  A[3] = 4
//  A[4] = 3
//We can split this tape in four places:
//
//P = 1, difference = |3 − 10| = 7
//P = 2, difference = |4 − 9| = 5
//P = 3, difference = |6 − 7| = 1
//P = 4, difference = |10 − 3| = 7
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
//
//For example, given:
//
//  A[0] = 3
//  A[1] = 1
//  A[2] = 2
//  A[3] = 4
//  A[4] = 3
//the function should return 1, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [2..100,000];
//each element of array A is an integer within the range [−1,000..1,000].


//To solve this problem efficiently, you can use the following algorithm:
//
// Certainly! To achieve better performance, you can optimize the solution by using a single loop to calculate
// both the total sum and the sum of the first part.
// This avoids the need for a separate loop to calculate the total sum. Here's an updated implementation in Java:
public class TapeEquilibriumEfficient {
    public int solution(int[] A) {
        int totalSum = 0;
        int firstPartSum = 0;

        // Calculate the total sum of the array and the sum of the first part
            for (int num : A) {
            totalSum += num;
    }

    int minDifference = Integer.MAX_VALUE;

    // Iterate through the array to find the minimal difference
        for (int i = 0; i < A.length - 1; i++) {
        firstPartSum += A[i];
        int secondPartSum = totalSum - firstPartSum;
        int currentDifference = Math.abs(firstPartSum - secondPartSum);

        // Update the minimum difference
        minDifference = Math.min(minDifference, currentDifference);
    }

        return minDifference;
}
}


//This solution still has a time complexity of O(N) and a space complexity of O(1),
// but it avoids redundant iterations through the array, potentially offering better performance.