package programmers.lv1.no64;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z\\d\\-_.]*", "");

        answer += new_id.charAt(0);
        for (int i = 1; i < new_id.length(); i++) {
            if (new_id.charAt(i - 1) == '.' && new_id.charAt(i) == '.') {
                continue;
            }
            answer += new_id.charAt(i);
        }

        if (answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (answer.length() != 0 && answer.charAt(answer.length()-1) == '.') {
            answer = answer.substring(0, answer.length()-1);
        }

        if (answer.length() == 0) {
            answer += "a";
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
        }

        if (answer.length() < 3) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String new_id = "=.=";
        s.solution(new_id);
    }
}