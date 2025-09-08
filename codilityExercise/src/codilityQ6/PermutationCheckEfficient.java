package codilityQ6;

public class PermutationCheckEfficient {

    public static void main(String[] args) {
        int[] A1 = {4, 1, 3, 2};
        int result1 = solution(A1);
        System.out.println("Is array a permutation? " + result1);

        int[] A2 = {4, 1, 3};
        int result2 = solution(A2);
        System.out.println("Is array a permutation? " + result2);
    }

    public static int solution(int[] A) {
        int N = A.length;
        boolean[] seen = new boolean[N + 1]; // Index 0 is not used

        for (int num : A) {
            if (num <= 0 || num > N || seen[num]) {
                return 0; // Element is out of range or duplicated
            }
            seen[num] = true;
        }

        // Check if all numbers from 1 to N are present
        for (int i = 1; i <= N; i++) {
            if (!seen[i]) {
                return 0; // Element is missing
            }
        }

        return 1; // Array is a permutation
    }
}

//In this solution, we use a boolean array seen to mark the presence of elements from 1 to N.
//        If we encounter an element that is out of range or already marked as seen, we return 0.
//        After processing the entire array, we check if all numbers from 1 to N have been seen.
//        If any number is missing, we return 0; otherwise, we return 1.
//
//        The time complexity of this solution is O(N), and the space complexity is O(N).
