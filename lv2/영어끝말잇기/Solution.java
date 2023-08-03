package programmers.lv2.영어끝말잇기;

import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {

        int count = 0;
        int fail = 0;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (i % n == 0) {
                count++;
            }
            if (list.size() == 0) {
                list.add(words[i]);
            } else if (list.get(list.size() - 1).charAt(list.get(list.size() - 1).length() - 1) == words[i].charAt(0) && !list.contains(words[i])) {
                list.add(words[i]);
            } else {
                fail = i % n + 1;
                break;
            }
        }
        if (list.size() == words.length) {
            count = 0;
            fail = 0;
        }
        int[] answer = {fail, count};
        return answer;
    }
}