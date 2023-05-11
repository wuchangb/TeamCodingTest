package fastcampus_codingtest.third.no3;

import java.util.*;

public class Solution {
    public String[] solution(int n, String[] queries) {
        PriorityQueue<Integer> canUse = new PriorityQueue<>();
        PriorityQueue<Integer> oneTime = new PriorityQueue<>();
        ArrayList<String> answerList = new ArrayList<>();
        Map<String, Integer> rentMap = new HashMap<>();
        String ip = "192.168.0.";

        for (int i = 1; i <= n; i++) {
            canUse.add(i);
            oneTime.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            String[] split = queries[i].split(" ");
            if (split[1].equals("request")) {
                if (canUse.size() > 0) {
                    if (rentMap.containsKey(split[0])) {
                        if (canUse.contains(rentMap.get(split[0]))) {
                            answerList.add(split[0] + " " + ip + rentMap.get(split[0]));
                            canUse.remove(rentMap.get(split[0]));
                        } else {
                            if (!oneTime.isEmpty()) {
                                Integer num = oneTime.poll();
                                answerList.add(split[0] + " " + ip + num);
                                canUse.remove(num);
                                rentMap.put(split[0], num);
                            } else {
                                Integer num = canUse.poll();
                                answerList.add(split[0] + " " + ip + num);
                                rentMap.put(split[0], num);
                            }
                        }
                    } else {
                        if (!oneTime.isEmpty()) {
                            Integer num = oneTime.poll();
                            answerList.add(split[0] + " " + ip + num);
                            canUse.remove(num);
                            rentMap.put(split[0], num);
                        } else {
                            Integer num = canUse.poll();
                            answerList.add(split[0] + " " + ip + num);
                            rentMap.put(split[0], num);
                        }
                    }
                } else {
                    answerList.add(split[0] + " reject");
                }
            } else {
                canUse.add(rentMap.get(split[0]));
            }
        }

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] queries = {"desktop1 request", "desktop2 request", "desktop3 request", "desktop1 release"};
        Solution sol = new Solution();
        String[] arr = sol.solution(n, queries);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
