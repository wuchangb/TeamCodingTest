package programmers.lv2.이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};

        while (!s.equals("1")) {
            int before = s.length();
            s = s.replace("0", "");
            answer[1] += before - s.length();
            s = "" + Integer.toBinaryString(s.length());
            answer[0]++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "01110";
        int[] solution = sol.solution(s);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }
}