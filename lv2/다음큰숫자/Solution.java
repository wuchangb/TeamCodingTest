package programmers.lv2.다음큰숫자;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int cnt = binary(n);
        for (int i = n+1; i <=1000000 ; i++) {
            if (binary(i) == cnt) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public int binary(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;

    }
}