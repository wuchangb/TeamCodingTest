package programmers.lv1.no20;

class Solution {
    public String solution(String s) {
        String answer = "";

        if (s.length() % 2 == 1) {
            answer += s.charAt(s.length()/2);
        } else {
            answer += s.charAt(s.length()/2-1);
            answer += s.charAt(s.length()/2);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(5/2);
    }
}