package programmers.lv1.no50;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int count = 0;
                    int sum = nums[i]+nums[j]+nums[k];
                    for (int l = 2; l <= sum; l++) {
                        if (sum % l == 0) {
                            count++;
                        }
                    }
                    if (count == 1) {
                        count=0;
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        Solution s = new Solution();
        s.solution(nums);
    }
}