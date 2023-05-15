package programmers.lv1.no54;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> list = new ArrayList<>();
        int min = score[0];
        for (int i = 0; i < score.length; i++) {
            if (list.size() < k) {
                if (score[i] < min) {
                    min = score[i];
                }
                list.add(score[i]);
                answer[i] = min;
            } else {
                if (score[i] > min) {
                    list.remove(Integer.valueOf(min));
                    list.add(score[i]);
                    Collections.sort(list);
                    min = list.get(0);
                }
                answer[i] = min;
            }

        }
        return answer;
    }
}