package MoreTest;

//There is an array A of N integers and three tiles. Each tile can cover two neighbouring numbers
//from the array but cannot intersect with another tile.
//It also cannot be placed outside the array, even partially.
//
//Write a Java function:
//class Solution { public int solition (int[] A); }
//that, given an array A of N integers, returns the maximum sum of numbers that can be covered using at most three tiles.
//
//        Examples:
//        1. Given A = [2, 3, 5, 2, 3, 4, 6, 4, 1], the function should return 25.
//There is only one optimal placement of tiles: (3,5), (3,4), (6,4).
//        2. Given A = [1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1], the function should return 35.
//One of the three optimal placements of tiles is (5, 3), (6, 10), (4,7).
//        3. Given A = [1, 2, 3, 3, 2], the function should return 10. There is one optimal placement of tiles: (2,3), (3, 2).
//Only two tiles can be used because A is too small to contain another one.
//4. Given A = [5, 10, 3], the function should return 15. Only one tile can be used.
//Write an efficient algorithm for the following assumptions:
//        - N is an integer within the range [2..100,000);
//        - each element of array A is an integer within the range [0..1,000,000].

public class TestQuestion3Old_Claude {
    public int solution(int[] A) {return 0;
    }

    // Test method to verify the solution
    public static void main(String[] args) {
        TestQuestion3Old_Claude sol = new TestQuestion3Old_Claude();

        // Test case 1: [2, 3, 5, 2, 3, 4, 6, 4, 1] should return 25
        int[] test1 = {2, 3, 5, 2, 3, 4, 6, 4, 1};
        System.out.println("Test 1: " + sol.solution(test1)); // Expected: 25

        // Test case 2: [1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1] should return 35
        int[] test2 = {1, 5, 3, 2, 6, 6, 10, 4, 7, 2, 1};
        System.out.println("Test 2: " + sol.solution(test2)); // Expected: 35

        // Test case 3: [1, 2, 3, 3, 2] should return 10
        int[] test3 = {1, 2, 3, 3, 2};
        System.out.println("Test 3: " + sol.solution(test3)); // Expected: 10

        // Test case 4: [5, 10, 3] should return 15
        int[] test4 = {5, 10, 3};
        System.out.println("Test 4: " + sol.solution(test4)); // Expected: 15

        // Additional test cases
        int[] test5 = {1, 2}; // Only one tile possible
        System.out.println("Test 5: " + sol.solution(test5)); // Expected: 3

        int[] test6 = {10, 1, 10, 1, 10}; // Test alternating pattern
        System.out.println("Test 6: " + sol.solution(test6)); // Expected: 22 (10+1, 1+10)
    }
}