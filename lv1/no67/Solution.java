package programmers.lv1.no67;

import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 4).equals(1) && stack.get(stack.size() - 3).equals(2) && stack.get(stack.size() - 2).equals(3) && stack.get(stack.size() - 1).equals(1)) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
}