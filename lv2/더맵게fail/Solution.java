package programmers.lv2.더맵게fail;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while (queue.peek() < K && queue.size() > 1) {
            int tmp = 0;
            int a = queue.poll();
            int b = queue.poll();
            tmp = a+(b*2);
            queue.add(tmp);
            answer++;
        }

        if (queue.peek() < K) return -1;

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        sol.solution(scoville, K);
    }
}