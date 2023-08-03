package programmers.lv1.no26;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long moneyL = (long)money;

        for (int i = 1; i <= count; i++) {
            moneyL -= price*i;
        }
        if (moneyL >= 0) {
            answer = 0;
        } else {
            answer = Math.abs(moneyL);
        }
        return answer;
    }
}