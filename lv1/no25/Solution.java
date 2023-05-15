package programmers.lv1.no25;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 57 || s.charAt(i) < 48) {
                answer = false;
                break;
            }
        }

        if(s.length()!=4 && s.length()!=6) {
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        String a = "12340";
        System.out.println(a.charAt(4)-0);
    }
}