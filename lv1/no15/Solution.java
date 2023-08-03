package programmers.lv1.no15;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                count++;
            }
        }
        if (count == 0) {
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[count];
        int answerC=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[answerC++] = arr[i];
            }
        }
        Arrays.sort(answer);
        return answer;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {5, 9, 7, 10};
        System.out.println(s.solution(arr, 5));
    }
}