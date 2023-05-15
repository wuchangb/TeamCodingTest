package programmers.lv2.귤고르기runtime초과;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (Integer key : map.keySet()) {
            list.add(map.get(key));
        }

        list.sort(Collections.reverseOrder());

        for (Integer count : list) {
            k -= count;
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
}
