package programmers.lv2.N개의최소공배수;

class Solution {
    public int solution(int[] arr) {
        int MIN = arr[0];

        for (int i = 1; i < arr.length; i++) {
            MIN = MIN * arr[i] / MAX(MIN, arr[i]);
        }
        return MIN;
    }

    public int MAX(int a, int b) {
        int tmp = Math.min(a, b);
        while (tmp > 0) {
            if (a % tmp == 0 && b % tmp == 0) {
                return tmp;
            }
            tmp--;
        }
        return tmp;
    }
}