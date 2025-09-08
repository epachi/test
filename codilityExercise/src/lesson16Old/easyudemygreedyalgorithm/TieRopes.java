package lesson16Old.easyudemygreedyalgorithm;

//There are N ropes numbered from 0 to N − 1, whose lengths are given in an array A, lying on the floor in a line. For each I (0 ≤ I < N), the length of rope I on the line is A[I].
//
//We say that two ropes I and I + 1 are adjacent. Two adjacent ropes can be tied together with a knot, and the length of the tied rope is the sum of lengths of both ropes. The resulting new rope can then be tied again.
//
//For a given integer K, the goal is to tie the ropes in such a way that the number of ropes whose length is greater than or equal to K is maximal.
//
//For example, consider K = 4 and array A such that:
//
//    A[0] = 1
//    A[1] = 2
//    A[2] = 3
//    A[3] = 4
//    A[4] = 1
//    A[5] = 1
//    A[6] = 3
//The ropes are shown in the figure below.
//
//
//
//We can tie:
//
//rope 1 with rope 2 to produce a rope of length A[1] + A[2] = 5;
//rope 4 with rope 5 with rope 6 to produce a rope of length A[4] + A[5] + A[6] = 5.
//After that, there will be three ropes whose lengths are greater than or equal to K = 4. It is not possible to produce four such ropes.
//
//Write a function:
//
//class Solution { public int solution(int K, int[] A); }
//
//that, given an integer K and a non-empty array A of N integers, returns the maximum number of ropes of length greater than or equal to K that can be created.
//
//For example, given K = 4 and array A such that:
//
//    A[0] = 1
//    A[1] = 2
//    A[2] = 3
//    A[3] = 4
//    A[4] = 1
//    A[5] = 1
//    A[6] = 3
//the function should return 3, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..100,000];
//K is an integer within the range [1..1,000,000,000];
//each element of array A is an integer within the range [1..1,000,000,000].

//To solve this problem efficiently, you can use the "greedy" approach.
// The idea is to iterate through the ropes, keeping track of the current rope's length and the count of tied ropes.
// Whenever the current rope's length is less than K,
// you tie it to the previous rope. When the current rope's length is greater than or equal to K, you start a new set of tied ropes.
public class TieRopes {
    public int solution(int K, int[] A) {
        int count = 0;
        int currentLength = 0;

        for (int ropeLength : A) {
            currentLength += ropeLength;

            if (currentLength >= K) {
                count++;
                currentLength = 0; // Start a new set of tied ropes
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TieRopes solution = new TieRopes();
        int K = 4;
        int[] A = {1, 2, 3, 4, 1, 1, 3};
        System.out.println(solution.solution(K, A)); // Output: 3
    }
}

//This solution has a time complexity of O(N), where N is the number of ropes.
// It iterates through the array once, and for each rope, it performs constant-time operations.
