package programmers.lv1.no33;

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);


        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]) {
                budget -= d[i];
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}