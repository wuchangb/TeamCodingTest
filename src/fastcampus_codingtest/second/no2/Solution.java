package fastcampus_codingtest.second.no2;

import java.util.*;

public class Solution {

    public int solution(int n, int m) {
        int answer = 0;
        int count = 0;

        while (n > 0) {
            n--;
            count++;
            answer++;
            if (count / m == 1) {
                n++;
                count = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 9;
        int m = 3;
        Solution s = new Solution();
        System.out.println(s.solution(n, m));
    }
}
