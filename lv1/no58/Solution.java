package programmers.lv1.no58;

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String par : participant) {
            map.put(par, map.getOrDefault(par, 0) + 1);
        }
        for (String com : completion) {
            map.put(com, map.get(com) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}