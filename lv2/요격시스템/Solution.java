package programmers.lv2.요격시스템;

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, ((o1, o2) -> (o1[1] - o2[1])));
        int missile = -1;

        for (int[] target : targets) {
            if (missile <= target[0]) {
                answer++;
                missile = target[1];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}