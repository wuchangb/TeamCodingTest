package programmers.lv2.카펫;

import java.util.HashMap;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = brown + yellow;

        for (int i = sum; i >= Math.sqrt(sum); i--) {
            if (sum % i == 0) {
                map.put(i, sum / i);
            }
        }

        for (Integer key : map.keySet()) {
            if ((key - 2) * (map.get(key) - 2) == yellow) {
                answer[0] = key;
                answer[1] = map.get(key);
            }
        }
        return answer;
    }
}
