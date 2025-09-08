package lesson7.easy;

//A string S consisting of N characters is called properly nested if:
//
//S is empty;
//S has the form "(U)" where U is a properly nested string;
//S has the form "VW" where V and W are properly nested strings.
//For example, string "(()(())())" is properly nested but string "())" isn't.
//
//Write a function:
//
//class Solution { public int solution(String S); }
//
//that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
//
//For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..1,000,000];
//string S is made only of the characters '(' and/or ')'.

import java.util.Stack;

//To solve this problem, you can use a stack to keep track of opening parentheses as you iterate through the string.
// When encountering a closing parenthesis, check if the stack is empty or if the top of the stack corresponds to a matching opening parenthesis.
// If both conditions are met, pop the opening parenthesis from the stack.
//
//Here's the Java implementation:
public class Nesting {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : S.toCharArray()) {
            if (bracket == '(') {
                // Opening parenthesis, push onto the stack
                stack.push(bracket);
            } else {
                // Closing parenthesis
                if (stack.isEmpty()) {
                    // Stack is empty, no matching opening parenthesis
                    return 0;
                }

                // Check if the top of the stack is a matching opening parenthesis
                char openBracket = stack.pop();
                if (bracket == ')' && openBracket != '(') {
                    return 0; // Mismatched parentheses
                }
            }
        }

        // If the stack is empty, all parentheses are properly nested
        return stack.isEmpty() ? 1 : 0;
    }
}

//This solution uses a stack to keep track of opening parentheses and checks if each closing parenthesis matches the corresponding opening parenthesis.
// If the stack becomes empty after processing the entire string, it means all parentheses are properly nested.
//
//The time complexity of this solution is O(N), where N is the length of the input string.
// The space complexity is O(N) in the worst case, as the stack can contain all opening parentheses.