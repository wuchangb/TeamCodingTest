package programmers.lv1.no55;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        map.put(3, 4);
        map.put(2, 5);
        map.put(1, 6);
        map.put(0, 6);
        ArrayList<Integer> winList = new ArrayList<>();
        ArrayList<Integer> lottoList = new ArrayList<>();
        for (int i = 0; i < lottos.length; i++) {
            winList.add(win_nums[i]);
            lottoList.add(lottos[i]);
        }
        int win = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (winList.contains(lottoList.get(i))) {
                win++;
            }
        }

        int count = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottoList.get(i).equals(0)) {
                count++;
            }
        }
        answer[0] = map.get(win + count);
        answer[1] = map.get(win);

        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        Solution s = new Solution();
        s.solution(lottos, win_nums);
    }
}