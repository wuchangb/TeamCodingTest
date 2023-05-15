package programmers.lv2.할인행사;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map.get(discount[i+j]) == null) break;
                map.put(discount[i + j], map.get(discount[i + j]) - 1);
            }
            int count = 1;
            for (String key : map.keySet()) {
                if (map.get(key) != 0) {
                    count = 0;
                    break;
                }
            }
            answer += count;

            for (int j = 0; j < want.length; j++) {
                map.put(want[j], number[j]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(sol.solution(want, number, discount));
    }
}