package programmers.lv2.Hindex;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        for (int i = 1; i <= citations.length; i++) {
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    count++;
                }
                if (count >= i) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}