package lesson14.medium;


//You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.
//
//You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N.
// Every element of the array should belong to some block.
//
//The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.
//
//The large sum is the maximal sum of any block.
//
//For example, you are given integers K = 3, M = 5 and array A such that:
//
//  A[0] = 2
//  A[1] = 1
//  A[2] = 5
//  A[3] = 1
//  A[4] = 2
//  A[5] = 2
//  A[6] = 2
//The array can be divided, for example, into the following blocks:
//
//[2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
//[2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
//[2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
//[2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
//The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
//
//Write a function:
//
//class Solution { public int solution(int K, int M, int[] A); }
//
//that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.
//
//For example, given K = 3, M = 5 and array A such that:
//
//  A[0] = 2
//  A[1] = 1
//  A[2] = 5
//  A[3] = 1
//  A[4] = 2
//  A[5] = 2
//  A[6] = 2
//the function should return 6, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N and K are integers within the range [1..100,000];
//M is an integer within the range [0..10,000];
//each element of array A is an integer within the range [0..M].



//Algorithm Explanation
//This problem can be solved efficiently using binary search combined with a greedy validation approach. Here's how it works:
//Key Insights
//
//Search Space: The minimum possible large sum is the maximum element in the array (when each large element gets its own block).
// The maximum possible large sum is the total sum of all elements (when we use only 1 block).
//Monotonic Property: If we can divide the array into K blocks with a maximum sum of X,
// we can also do it with any value greater than X. This monotonic property allows us to use binary search.
//
//        Algorithm Steps
//
//Binary Search Setup:
//
//left = max(A) - minimum possible large sum
//right = sum(A) - maximum possible large sum
//
//
//Binary Search Loop:
//
//For each middle value mid, check if we can divide the array into at most K blocks where each block sum ≤ mid
//If possible, try a smaller value (right = mid)
//If not possible, we need a larger value (left = mid + 1)
//
//
//Validation Function (canDivide):
//
//Use a greedy approach: iterate through the array and keep adding elements to the current block
//When adding the next element would exceed maxSum, start a new block
//If we need more than K blocks, return false
//If any single element exceeds maxSum, return false
//
//
//
//Time Complexity
//
//Binary Search: O(log(sum - max)) where sum is total array sum and max is maximum element
//Validation: O(N) for each binary search iteration
//Overall: O(N × log(sum)) which is very efficient for the given constraints
//
//Space Complexity
//
//O(1) - only using a few variables
//
//Example Walkthrough
//For the given example A = [2,1,5,1,2,2,2], K = 3:
//
//left = 5 (max element), right = 15 (total sum)
//Try mid = 10: Can we divide into ≤3 blocks with max sum ≤10?
//
//Block 1: [2,1,5,1] (sum=9) ✓
//Block 2: [2,2,2] (sum=6) ✓
//Only 2 blocks needed, so YES
//
//
//Try mid = 7: Can we divide with max sum ≤7?
//
//Block 1: [2,1] (sum=3)
//Block 2: [5,1] (sum=6)
//Block 3: [2,2,2] (sum=6)
//        3 blocks needed, so YES
//
//
//Try mid = 6: Can we divide with max sum ≤6?
//
//Same division as above works, so YES
//
//
//Try mid = 5: Can we divide with max sum ≤5?
//
//Would need: [2,1], [5], [1,2,2], [2] = 4 blocks > 3, so NO
//
//
//Answer: 6

class MinMaxDivisionUsingClaudeRevisit {
    public int solution(int K, int M, int[] A) {
        // Binary search boundaries
        int left = getMaxElement(A);  // Minimum possible large sum
        int right = getTotalSum(A);   // Maximum possible large sum

        // Binary search for the minimum large sum
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canDivide(A, K, mid)) {
                right = mid;  // Try smaller large sum
            } else {
                left = mid + 1;  // Need larger large sum
            }
        }

        return left;
    }

    // Check if we can divide array into at most K blocks with max sum <= maxSum
    private boolean canDivide(int[] A, int K, int maxSum) {
        int blocks = 1;
        int currentSum = 0;

        for (int num : A) {
            // If single element exceeds maxSum, impossible
            if (num > maxSum) {
                return false;
            }

            // If adding current element exceeds maxSum, start new block
            if (currentSum + num > maxSum) {
                blocks++;
                currentSum = num;

                // If we need more than K blocks, impossible
                if (blocks > K) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }

        return true;
    }

    private int getMaxElement(int[] A) {
        int max = A[0];
        for (int num : A) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getTotalSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        return sum;
    }

    // Test method to verify the solution
    public static void main(String[] args) {
        MinMaxDivisionUsingClaudeRevisit sol = new MinMaxDivisionUsingClaudeRevisit();

        // Test case from the problem
        int[] A = {2, 1, 5, 1, 2, 2, 2};
        int K = 3;
        int M = 5;

        int result = sol.solution(K, M, A);
        System.out.println("Result: " + result); // Should output 6

        // Additional test cases
        int[] A2 = {1, 2, 3, 4, 5};
        int result2 = sol.solution(3, 5, A2);
        System.out.println("Result 2: " + result2); // Should output 6

        int[] A3 = {1, 1, 1, 1, 1, 1};
        int result3 = sol.solution(2, 1, A3);
        System.out.println("Result 3: " + result3); // Should output 3
    }

}

//This Java implementation follows a similar logic as the Python solution. It defines a Solution class with a solution method and a private isValid method to check the validity of the blocks.
// The binary search is used to find the minimal large sum.