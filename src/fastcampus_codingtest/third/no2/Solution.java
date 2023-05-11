package fastcampus_codingtest.third.no2;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] nums) {

        int N = nums.length/2;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }

        if (list.size() >= N) {
            return N;
        } else {
            return list.size();
        }
    }
}
