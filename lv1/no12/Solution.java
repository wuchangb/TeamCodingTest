package programmers.lv1.no12;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        if (a == b) {
            answer = a;
        } else if (a < b) {
            while (a <= b) {
                answer += a;
                a++;
            }
        } else {
            while (a >= b) {
                answer += a;
                a--;
            }
        }
        return answer;
    }
}