package programmers.lv1.no4;

class Solution {
    public int[] solution(long n) {
        String answerS = String.valueOf(n);
        int[] answer = new int[answerS.length()];

        for (int i = 0; i < answerS.length(); i++) {

            answer[i]=Integer.parseInt(String.valueOf(answerS.charAt(answerS.length()-i-1)));
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(12345));
    }
}