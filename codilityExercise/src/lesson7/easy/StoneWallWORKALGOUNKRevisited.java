package lesson7.easy;

//You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant;
// however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers.
// H[I] is the height of the wall from I to I+1 meters to the right of its left end.
// In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
//
//The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular).
// Your task is to compute the minimum number of blocks needed to build the wall.
//
//Write a function:
//
//class Solution { public int solution(int[] H); }
//
//that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.
//
//For example, given array H containing N = 9 integers:
//
//  H[0] = 8    H[1] = 8    H[2] = 5
//  H[3] = 7    H[4] = 9    H[5] = 8
//  H[6] = 7    H[7] = 4    H[8] = 8
//the function should return 7. The figure shows one possible arrangement of seven blocks.
//
//
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..100,000];
//each element of array H is an integer within the range [1..1,000,000,000].

import java.util.Stack;

//To solve this problem, we can use a stack to keep track of the heights of the currently open blocks.
// We iterate through the heights, and for each height, we pop the blocks from the stack until we find a height smaller than the current one.
// For each block popped, we count it as a separate block, as it needs to be placed separately.
public class StoneWallWORKALGOUNKRevisited {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blocksNeeded = 0;

        for (int height : H) {
            // Pop blocks until the stack is empty or the height is smaller
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
                blocksNeeded++;
            }

            // If the stack is empty or the height is greater, add a new block
            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
            }
        }

        // The remaining blocks in the stack need separate placement
        blocksNeeded += stack.size();

        return blocksNeeded;
    }

    public static void main(String[] args) {
        StoneWallWORKALGOUNKRevisited solution = new StoneWallWORKALGOUNKRevisited();
//        int [] H = {8, 8};
        int [] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};

        System.out.println(solution.solution(H));
    }
}

//This solution uses a stack to keep track of the heights of the currently open blocks.
// For each height encountered, it pops the blocks from the stack until finding a height smaller than the current one.
// For each popped block, it increments the blocksNeeded counter.
// If the stack is empty or the current height is greater than the top of the stack, a new block is added to the stack.
// Finally, the remaining blocks in the stack need separate placement, so their count is added to the blocksNeeded counter.
//
//The time complexity of this solution is O(N), where N is the length of the input array.
// The space complexity is also O(N) in the worst case, as the stack may contain all heights.