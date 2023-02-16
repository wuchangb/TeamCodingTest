package programmers.lv1.no17;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int tmp=0;

        if(arr.length==1){
            int[] answer = {-1};
            return answer;
        }

        tmp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (tmp >= arr[i]) {
                tmp = arr[i];
            }
        }
        int[] answer = new int[arr.length-1];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tmp) {
                continue;
            }
            answer[count++] = arr[i];
        }
        return answer;
    }
}