package programmers.lv1.no2;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String length = String.valueOf(n);
        for (int i = 0; i < length.length(); i++) {
            answer += length.charAt(i)-48;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(456));
    }
}