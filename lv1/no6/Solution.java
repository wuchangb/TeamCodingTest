package programmers.lv1.no6;

class Solution {
    public long solution(long n) {
        long answer = -1;
        for (int i = 1; i < 7071068; i++) {
            if (n % i == 0 && n / i % i == 0 && n / i / i == 1) {
                answer = (n/i+1)*(n/i+1);
                break;
            }
        }
        return answer;
    }
}