package lesson16Old.easyudemygreedyalgorithm;

// To solve this problem efficiently, you can use the "greedy" approach. The idea is to iterate through the ropes,
// keeping track of the current rope's length and the count of tied ropes. Whenever the current rope's length is less than K,
// you tie it to the previous rope.
// When the current rope's length is greater than or equal to K, you start a new set of tied ropes.
public class TieRopesEfficient {
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
        TieRopesEfficient solution = new TieRopesEfficient();
        int K = 4;
        int[] A = {1, 2, 3, 4, 1, 1, 3};
        System.out.println(solution.solution(K, A)); // Output: 3
    }
}

//This solution has a time complexity of O(N) and avoids unnecessary repeated calculations.
// It iterates through the array only once, and the inner while loop adjusts the pointers efficiently.
// The count is updated by considering all ropes from the current end pointer to the end of the array.

//This solution has a time complexity of O(N), where N is the number of ropes.
// It iterates through the array once, and for each rope, it performs constant-time operations.
