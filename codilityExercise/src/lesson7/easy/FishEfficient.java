package lesson7.easy;

//We can achieve a more efficient solution by eliminating the need for the stack.
// We can iterate through the fish only once, keeping track of the downstream fish and handling the interactions with upstream fish accordingly.
//
//Here's the more efficient Java implementation:

import java.util.Stack;

public class FishEfficient {
    public int solution(int[] A, int[] B) {
        int downstreamFishCount = 0;
        int aliveFishCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                // Downstream fish
                downstreamFishCount++;
            } else {
                // Upstream fish
                while (downstreamFishCount > 0) {
                    // Compare with the last downstream fish
                    if (A[i] > A[i - downstreamFishCount]) {
                        // Upstream fish eats the last downstream fish
                        downstreamFishCount--;
                    } else {
                        // Downstream fish eats the upstream fish
                        break;
                    }
                }

                // If no downstream fish left, upstream fish survives
                if (downstreamFishCount == 0) {
                    aliveFishCount++;
                }
            }
        }

        // The remaining downstream fish are considered alive
        aliveFishCount += downstreamFishCount;

        return aliveFishCount;
    }
}
//This solution iterates through the fish once, updating counts as it encounters downstream or upstream fish.
// It eliminates the need for a stack and simplifies the logic to handle the interactions between upstream and downstream fish.
// The time complexity is still O(N), and the space complexity is O(1) since we don't use additional data structures that scale with the input size.