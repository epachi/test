package exercise4AlgoSkills.easy;
//A non-empty array A consisting of N integers is given. The unique number is the number that occurs exactly once in array A.
//
//        For example, the following array A:
//
//        A[0] = 4
//        A[1] = 10
//        A[2] = 5
//        A[3] = 4
//        A[4] = 2
//        A[5] = 10
//        contains two unique numbers (5 and 2).
//
//        You should find the first unique number in A. In other words, find the unique number with the lowest position in A.
//
//        For above example, 5 is in second position (because A[2] = 5) and 2 is in fourth position (because A[4] = 2). So,
//        the first unique number is 5.
//
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A of N integers, returns the first unique number in A. The function should return −1 if there are no unique numbers in A.
//
//        For example, given:
//
//        A[0] = 1
//        A[1] = 4
//        A[2] = 3
//        A[3] = 3
//        A[4] = 1
//        A[5] = 2
//        the function should return 4. There are two unique numbers (4 and 2 occur exactly once). The first one is 4 in position 1 and the second one is 2 in position 5. The function should return 4 bacause it is unique number with the lowest position.
//
//        Given array A such that:
//
//        A[0] = 6
//        A[1] = 4
//        A[2] = 4
//        A[3] = 6
//        the function should return −1. There is no unique number in A (4 and 6 occur more than once).
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        each element of array A is an integer within the range [0..1,000,000,000].

//To solve this problem efficiently, we can use a combination of data structures to keep track of unique numbers and their positions.
//        Specifically, we can use a HashMap to store the count and the first occurrence position of each number in the array.

import java.util.HashMap;
public class FirstUnique {
    public int solution(int[] A) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> positionMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int num = A[i];

            // Update count and position for the current number
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            positionMap.putIfAbsent(num, i);
        }

        int firstUnique = -1;

        for (int num : countMap.keySet()) {
            if (countMap.get(num) == 1 && (firstUnique == -1 || positionMap.get(num) < positionMap.get(firstUnique))) {
                // Update the first unique number with the lowest position
                firstUnique = num;
            }
        }

        return firstUnique;
    }

    public static void main(String[] args) {
        FirstUnique solution = new FirstUnique();

        // Example 1
        int[] A1 = {1, 4, 3, 3, 1, 2};
        System.out.println(solution.solution(A1)); // Output: 4

        // Example 2
        int[] A2 = {6, 4, 4, 6};
        System.out.println(solution.solution(A2)); // Output: -1
    }
}

//In this solution, we iterate through the array to build two HashMaps: countMap to store the count of each number and
//        positionMap to store the first occurrence position of each number.
//        Then, we iterate through the countMap to find the first unique number with the lowest position. If no unique numbers are found, the function returns -1.
