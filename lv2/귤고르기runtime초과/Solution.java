package programmers.lv2.귤고르기runtime초과;

import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[tangerine.length+1];

        for (int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]]++;
        }

        Arrays.sort(arr);

        for (int i = tangerine.length; i >=0; i--) {
            k -= arr[i];
            answer++;
            if (k <=0) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        s.solution(k, tangerine);
    }
}