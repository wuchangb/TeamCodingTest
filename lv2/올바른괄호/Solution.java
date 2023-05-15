package programmers.lv2.올바른괄호;

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.size() == 0) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        if (stack.size() != 0) {
            answer = false;
        }

        return answer;
    }
}