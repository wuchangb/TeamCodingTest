package fastcampus_codingtest.firstTest.no2;

import java.util.Arrays;

public class Solution {
    public int solution(int h, int k, int[] boxes) {
        int answer = 0;

        Arrays.sort(boxes);
        int box = 0;
        int tmp = 0;

        for (int i = 0; i < boxes.length; i++) {
            if (box + k >= boxes[i]) {
                tmp = boxes[i];
            } else if (box + k < boxes[i]) {
                box = tmp;
                tmp = boxes[i];
                answer++;
            }

            if (h <= tmp + k) {
                answer++;
                break;
            }
        }

        if (tmp + k < h) {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] boxes = {1};
        Solution s = new Solution();
        System.out.println(s.solution(20, 18, boxes));
    }
}
