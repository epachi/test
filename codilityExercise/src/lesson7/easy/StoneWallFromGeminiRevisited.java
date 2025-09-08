package lesson7.easy;
import java.util.Stack;

//The provided solution is already quite efficient with a time complexity of O(N), where N is the length of the input array.
// The stack is used to efficiently keep track of the heights while processing the array elements.
//
//However, if you're looking for an alternative approach without using a stack, you can use a similar idea but without an explicit stack.
// Instead, you can use a variable to keep track of the current height and an array to store the heights of the blocks.
// This approach avoids the use of a stack data structure.
public class StoneWallFromGeminiRevisited {
    /**
     * Computes the minimum number of blocks needed to build a wall with the given height profile.
     * The wall has N meters, and H[i] specifies the height of the wall from i to i+1 meters.
     *
     * @param H An array of N positive integers specifying the height of the wall.
     * @return The minimum number of blocks needed to build the wall.
     */
    public int solution(int[] H) {
        if (H == null || H.length == 0) {
            return 0;
        }

        // Stack to keep track of the heights of currently "open" blocks.
        // An "open" block means a block that could potentially extend further to the right.
        Stack<Integer> stack = new Stack<>();
        int blocks = 0; // Counter for the minimum number of blocks

        for (int height : H) {
            // While the stack is not empty and the current height is less than the height
            // at the top of the stack, it means the block represented by the stack top
            // cannot extend to the current position. So, we pop it.
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }

            // If the stack is empty, or the current height is different from the height
            // at the top of the stack, it means we need to start a new block at this height.
            // We increment the block count and push the current height onto the stack.
            if (stack.isEmpty() || stack.peek() != height) {
                blocks++;
                stack.push(height);
            }
            // If stack.peek() == height, it means the current block can extend,
            // so no new block is needed, and the stack remains unchanged.
        }

        return blocks;
    }

    public static void main(String[] args) {
        StoneWallFromGeminiRevisited solution = new StoneWallFromGeminiRevisited();
//        int [] H = {8, 8};
        int [] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};

        System.out.println(solution.solution(H));
    }
}

//This alternative solution avoids using a stack explicitly and uses an array (blockHeights) to store the heights of the blocks.
// The time complexity remains O(N), and the space complexity is O(N) due to the array used to store block heights.
// Keep in mind that both the stack-based and the array-based solutions are efficient,
// and the choice between them may depend on specific requirements or preferences.

//This solution uses a stack to keep track of the heights of the currently open blocks.
// For each height encountered, it pops the blocks from the stack until finding a height smaller than the current one.
// For each popped block, it increments the blocksNeeded counter.
// If the stack is empty or the current height is greater than the top of the stack, a new block is added to the stack.
// Finally, the remaining blocks in the stack need separate placement, so their count is added to the blocksNeeded counter.
//
//The time complexity of this solution is O(N), where N is the length of the input array.
// The space complexity is also O(N) in the worst case, as the stack may contain all heights.