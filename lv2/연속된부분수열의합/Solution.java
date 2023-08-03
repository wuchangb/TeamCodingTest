package programmers.lv2.연속된부분수열의합;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;
        int length = sequence.length;
        int left = 0;
        int right = 0;
        int sum = 0;

        for (right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                if (length > right - left) {
                    answer[0] = left;
                    answer[1] = right;
                    length = right - left;
                } else if (length == right - left) {
                    answer[0] = Math.min(answer[0], left);
                    answer[1] = Math.min(answer[1], right);
                }
            }
        }
        return answer;
    }
}