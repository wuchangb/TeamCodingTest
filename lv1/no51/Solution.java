package programmers.lv1.no51;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            double fail = 0.0;
            double total = 0.0;

            for (int j = 0; j < stages.length; j++) {
                if (i <= stages[j]) {
                    total++;
                }
                if (i == stages[j]) {
                    fail++;
                }
            }
            if (total == 0 && fail == 0) {
                total = 1;
            }
            map.put(i, (double) (fail / total));
        }

        for (int i = 0; i < N; i++) {
            double max = -1;
            int index = 0;
            for (int key : map.keySet()) {
                if (max < map.get(key)) {
                    max = map.get(key);
                    index = key;
                }
            }
            answer[i] = index;
            map.remove(index);
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        Solution s = new Solution();
        s.solution(N, stages);
    }
}
