package programmers.lv1.no53;

import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        int index = list.size()/m;
        for (int i = 1; i <= index; i++) {
            answer += list.get(i*m-1)*m;
        }
//        while (list.size() >= m) {
//            for (int i = 0; i < m-1; i++) {
//                list.remove(0);
//            }
//            answer += list.get(0)*m;
//            list.remove(0);
//        }
        return answer;
    }
}