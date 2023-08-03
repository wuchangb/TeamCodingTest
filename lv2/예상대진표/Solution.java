package programmers.lv2.예상대진표;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        int A = a;
        int B = b;
        for (int i = 0; i < n / 2; i++) {
            if (A/2 != B/2 && Math.abs(A-B)==1) break;
            A = battle(A);
            B = battle(B);
            answer++;
        }
        return answer;
    }

    public int battle(int num) {
        if (num % 2 == 0) {
            return num / 2;
        } else {
            return (num / 2) + 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(8, 4, 7);
    }
}