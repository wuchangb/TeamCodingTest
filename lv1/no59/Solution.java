package programmers.lv1.no59;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count(i) > limit) {
                answer += power;
            } else {
                answer += count(i);
            }
        }
        return answer;
    }

    public int count(int num) {
        int count=0;
        for (int i = 1; i*i <= num; i++) {
            if (i*i==num) {
                count++;
            } else if (num % i == 0) {
                count +=2;
            }
        }
        return count;
    }
}