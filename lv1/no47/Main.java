package programmers.lv1.no47;

import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                answer[i] = -1;
            } else {
                int same = 0;
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        same = j;
                    }
                }
                answer[i] = i-same;
            }
        }
        return answer;
    }
}