package org.leetcode;

import java.util.Stack;

public class ValidParentheses {

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

 */
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        String input = "()";
        boolean result = solution.validParentheses(input);

        System.out.println(result);
    }
    public boolean validParentheses(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; //for cases like }}, )), ([}}]) this will return false
            } //stack.push(c)
        }
        return stack.isEmpty();
    }
}
