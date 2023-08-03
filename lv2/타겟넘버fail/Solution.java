package programmers.lv2.타겟넘버fail;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        int sum = 0;
        cal(0, numbers, sum, target);
        return answer;
    }

    public void cal(int start, int[] numbers, int sum, int target) {

        if (start == numbers.length) {
            if (sum == target) {
                answer++;
            }
        } else {
            cal(start+1, numbers, sum + numbers[start], target);
            cal(start+1, numbers, sum - numbers[start], target);
        }

    }

}