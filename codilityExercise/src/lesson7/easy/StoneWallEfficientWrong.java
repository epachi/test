package lesson7.easy;


//The provided solution is already quite efficient with a time complexity of O(N), where N is the length of the input array.
// The stack is used to efficiently keep track of the heights while processing the array elements.
//
//However, if you're looking for an alternative approach without using a stack, you can use a similar idea but without an explicit stack.
// Instead, you can use a variable to keep track of the current height and an array to store the heights of the blocks.
// This approach avoids the use of a stack data structure.
public class StoneWallEfficientWrong {
    public int solution(int[] H) {
        int blocksNeeded = 0;
        int currentHeight = 0;
        int[] blockHeights = new int[H.length];

        for (int height : H) {
            // Pop blocks until the current height is smaller
            while (currentHeight > height) {
                currentHeight -= blockHeights[blocksNeeded - 1];
                blocksNeeded--;
            }

            // If the current height is smaller or a new block is needed
            if (currentHeight < height) {
                int newBlockHeight = height - currentHeight;
                blockHeights[blocksNeeded] = newBlockHeight;
                currentHeight += newBlockHeight;
                blocksNeeded++;
            }
        }

        return blocksNeeded;
    }

    public static void main(String[] args) {
        StoneWallEfficientWrong solution = new StoneWallEfficientWrong();
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