package programmers.lv2.숫자의표현;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int number = n;
        for (int i = 1; i <= n / 2; i++) {
            int tmp = 0;
            while (number > 0) {
                number -= i+tmp;
                tmp++;
            }
            if (number == 0) {
                answer++;
            }
            number = n;
        }
        answer = answer +1;
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(15));
    }
}


