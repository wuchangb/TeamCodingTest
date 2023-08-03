package programmers.lv1.no36;

import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int[] max = new int[sizes.length];
        int[] min = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            max[i] = Math.max(sizes[i][0], sizes[i][1]);
            min[i] = Math.min(sizes[i][0], sizes[i][1]);
        }

        Arrays.sort(max);
        Arrays.sort(min);

        answer = max[sizes.length-1] * min[sizes.length-1];
        return answer;
    }
}