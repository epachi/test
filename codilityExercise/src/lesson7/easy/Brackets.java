package lesson7.easy;

//A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
//
//S is empty;
//S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
//S has the form "VW" where V and W are properly nested strings.
//For example, the string "{[()()]}" is properly nested but "([)()]" is not.
//
//Write a function:
//
//class Solution { public int solution(String S); }
//
//that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
//
//For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [0..200,000];
//string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.

import java.util.Stack;

//
//To solve this problem, you can use a stack data structure to keep track of the opening brackets as you iterate through the string.
//        When encountering a closing bracket, you can check if it matches the corresponding opening bracket at the top of the stack.
//        If it does, pop the opening bracket from the stack; otherwise, the string is not properly nested.
public class Brackets {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();             //<======== Stack<Character> stack = new Stack<>();

        for (char bracket : S.toCharArray()) {              //<======== S.toCharArray()
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);                        //<======== stack.push(bracket)
            } else {
                if (stack.isEmpty()) {
                    return 0; // No matching opening bracket
                }

                char openBracket = stack.pop();

                // Check if the opening bracket matches the corresponding closing bracket
                if (bracket == ')' && openBracket != '(' ||
                        bracket == '}' && openBracket != '{' ||
                        bracket == ']' && openBracket != '[') {
                    return 0; // Mismatched brackets
                }
            }
        }

        // Check if all opening brackets are closed properly
        return stack.isEmpty() ? 1 : 0;
    }
}

//This solution uses a stack to keep track of the opening brackets encountered.
// It iterates through the input string, pushing opening brackets onto the stack and popping matching opening brackets when encountering a closing bracket.
// If the stack becomes empty, the string is properly nested.
//
//The time complexity of this solution is O(N), where N is the length of the input string.
// The space complexity is also O(N) in the worst case, as the stack can store all opening