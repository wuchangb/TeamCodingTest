package programmers.lv2.캐시;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            if (queue.contains(cities[i].toLowerCase())) {
                queue.remove(cities[i].toLowerCase());
                queue.add(cities[i].toLowerCase());
                answer += 1;
            } else {
                if (queue.size() < cacheSize) {
                    queue.add(cities[i].toLowerCase());
                    answer += 5;
                } else {
                    queue.poll();
                    queue.add(cities[i].toLowerCase());
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
