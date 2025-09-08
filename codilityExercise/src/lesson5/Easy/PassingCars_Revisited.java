package lesson5.Easy;

//A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
//
//Array A contains only 0s and/or 1s:
//
//0 represents a car traveling east,
//1 represents a car traveling west.
//The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
//
//For example, consider array A such that:
//
//  A[0] = 0
//  A[1] = 1
//  A[2] = 0
//  A[3] = 1
//  A[4] = 1
//We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
//
//The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
//
//For example, given:
//
//  A[0] = 0
//  A[1] = 1
//  A[2] = 0
//  A[3] = 1
//  A[4] = 1
//the function should return 5, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..100,000];
//each element of array A is an integer that can have one of the following values: 0, 1.

//You can solve this problem with a linear-time algorithm. Here's a Java implementation:


// Also, see explanation (but different code) in Chapter 54 of
// https://www.udemy.com/course/beat-the-codility-coding-interview-in-java/learn/lecture/14143441#overview
public class PassingCars_Revisited {
        public int solution(int[] A) {
            int eastCars = 0;
            int passingPairs = 0;

            for (int car : A) {
                if (car == 0) {
                    eastCars++;
                } else {
                    passingPairs += eastCars;
                }

                if (passingPairs > 1_000_000_000) {
                    return -1; // Check for exceeding the limit
                }
            }

            return passingPairs;
        }
}
//This algorithm iterates through the array once, keeping track of the number of east-traveling cars and counting passing pairs. The variable eastCars represents the number of east-traveling cars encountered so far. When a west-traveling car is encountered, the number of passing pairs is increased by the current count of east-traveling cars. If the total number of passing pairs exceeds 1,000,000,000, the function returns -1.
//
//This solution has a time complexity of O(N), where N is the length of the array A, and constant space complexity.