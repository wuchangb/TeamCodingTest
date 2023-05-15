package programmers.lv2.최댓값과최솟값;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(list);
        answer += list.get(0);
        answer += " ";
        answer += list.get(list.size()-1);
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("asdfdsf"));
    }
}