package programmers.lv1.no8;

import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = "";
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr);
        for (int i = arr.length-1; i >=0; i--) {
            str += arr[i];
        }
        answer = Long.parseLong(str);
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(118372));

        }

}