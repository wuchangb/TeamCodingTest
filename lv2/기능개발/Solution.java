package programmers.lv2.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int days = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                days++;
            }
            queue.add(days);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (queue.size() > 0) {
            int count = 1;
            int tmp = queue.poll();
            while (queue.size() > 0) {
                if (queue.peek() <= tmp) {
                    queue.poll();
                    count++;
                } else {
                    break;
                }
            }
            list.add(count);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}