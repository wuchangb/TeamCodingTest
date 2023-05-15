package programmers.lv1.no45;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        String reverse = "";

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer += i;
            }
        }

        for (int i = 0; i < answer.length(); i++) {
            reverse += answer.charAt(answer.length() - 1 - i);
        }
        answer += 0 + reverse;
        return answer;
    }
}