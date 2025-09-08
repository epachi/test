package lesson7.easy;

//The provided solution with a stack already has an optimal time complexity of O(N), where N is the length of the input string.
// This is because the algorithm iterates through the string once, and each operation (push or pop) on the stack takes constant time.
//
//However, if you are looking for a solution without using a stack, you can use a simple counter to keep track of the balance of parentheses.
// If the counter becomes negative at any point, you can immediately return 0, indicating that the parentheses are not properly nested.
// At the end of the iteration, if the counter is zero, the parentheses are properly nested.

import java.util.Stack;


public class NestingEfficient {
    public int solution(String S) {
        int balance = 0;

        for (char bracket : S.toCharArray()) {
            if (bracket == '(') {
                // Opening parenthesis, increment the balance
                balance++;
            } else {
                // Closing parenthesis
                balance--;

                // Check for negative balance
                if (balance < 0) {
                    return 0; // Not properly nested
                }
            }
        }

        // Check if balance is zero at the end
        return balance == 0 ? 1 : 0;
    }
}

//    This solution eliminates the need for a stack and uses a single integer variable (balance) to keep track of the nesting.
//        It has the same time complexity of O(N) as the stack-based solution,
//        but it might be slightly faster in practice due to the reduced overhead of stack operations. The space complexity is O(1),
//        as it uses only a single integer variable.