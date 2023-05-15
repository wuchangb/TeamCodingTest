package programmers.lv2.모음사전fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    static List<String> list;
    static String[] arr = {"A","E","I","O","U"};

    public int solution(String word) {
        list = new ArrayList<>();
        int answer = 0;
        recur(0, "");
        Collections.sort(list);
        answer = list.indexOf(word)+1;
        return answer;
    }

    public void recur(int index, String str) {
        if (index >= 5) return;
        for (int i = 0; i < arr.length; i++) {
            list.add(str+arr[i]);
            recur(index + 1, str + arr[i]);
        }
    }
}