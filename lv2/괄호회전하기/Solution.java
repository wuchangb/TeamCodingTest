package programmers.lv2.괄호회전하기;

import java.util.Stack;

class Solution {
    static Stack<Character> stack = new Stack<>();
    static int answer = 0;

    public int solution(String s) {

        counter(s);

        for (int i = 1; i < s.length(); i++) {
            s = s + s.charAt(0);
            s = s.substring(1);
            counter(s);
        }

        return answer;
    }

    static void counter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
            } else {
                if ((stack.peek() == '[' && s.charAt(i) == ']') ||
                        (stack.peek() == '{' && s.charAt(i) == '}') ||
                        (stack.peek() == '(' && s.charAt(i) == ')')) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.size() == 0) {
            answer++;
        }
        stack.clear();
    }
}