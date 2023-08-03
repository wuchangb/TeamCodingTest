package programmers.lv2.주식가격;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            queue.add(prices[i]);
        }

        int count = 0;
        while (queue.size() > 1) {
            Integer price = queue.poll();

            for (int i = count+1; i < prices.length-1; i++) {
                if (price <= prices[i]) {
                    answer[count]++;
                } else {
                    break;
                }
            }
            answer[count]++;
            count++;
        }

        return answer;
    }
}