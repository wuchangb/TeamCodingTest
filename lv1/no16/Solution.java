package programmers.lv1.no16;

class Solution {
    public String solution(String phone_number) {
        String answer = "";

        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }
        for (int i = 0; i < 4; i++) {
            answer += phone_number.charAt(phone_number.length()-4+i);
        }
        return answer;
    }
}