package fastcampus_codingtest.firstTest.no3;

public class Solution {
    public int solution(String s) {

        String answer = "";

        for (int i = 0; i < s.length(); i++) {

            if (answer.length() == 0) {
                answer += s.charAt(i);
            } else if (answer.charAt(answer.length() - 1) == s.charAt(i)) {
                answer = answer.substring(0, answer.length() - 1);
            } else {
                answer += s.charAt(i);
            }
        }

        if (answer.length() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "cdcd";
        System.out.println(s.solution(str));
    }
}
