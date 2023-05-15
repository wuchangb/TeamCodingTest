package programmers.lv2.n2배열자르기;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Long> solution(int n, long left, long right) {

        List<Long> list = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            list.add(Math.max(i/n,i%n)+1);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;
        long left = 2;
        long right = 5;
        s.solution(n, left, right);
    }
}
