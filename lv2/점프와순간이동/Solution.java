package programmers.lv2.점프와순간이동;

public class Solution {
    public int solution(int n) {
        int answer = 1;

        while (n > 1) {
            if (n % 2 == 1) {
                answer++;
                n /= 2;
            } else {
                n /=2;
            }
        }
        return answer;
    }
}
