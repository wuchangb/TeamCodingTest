package programmers.lv1.no29;

class Solution {
    public int[] solution(int n, int m) {
        int max = 1;
        int min = 1;

        for (int i = 1; i <= Math.max(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                max = i;
            }
        }
        min = n*m/max;
        int[] answer = {max, min};
        return answer;
    }
}