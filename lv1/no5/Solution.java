package programmers.lv1.no5;

class Solution {

    boolean solution(String s) {
        boolean answer = false;
        int score=0;
        char ch = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                score++;
            } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                score--;
            }
        }
        if(score == 0) answer = true;

        return answer;
    }

    public static void main(String[] args) {

    }
}