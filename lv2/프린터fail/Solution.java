package programmers.lv2.프린터fail;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer integer : priorities) {
            queue.add(integer);
        }

        while (queue.size() > 0) {
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++;

                    if (i == location) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}