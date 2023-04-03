package fastcampus_codingtest.second.no1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Stack<Integer> page = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        String[] arr = s.split(" ");
        Map<Integer, Integer> map = new HashMap<>();

        for (int i =0; i < arr.length; i++) {
            if (arr[i].charAt(0) >= 48 && arr[i].charAt(0) <= 57) {
                page.push(Integer.parseInt(arr[i]));
                map.put(Integer.parseInt(arr[i]), map.getOrDefault(Integer.parseInt(arr[i]), 0)+1);
                stack.clear();
            } else if (arr[i].equals("B")) {
                if(page.size() == 0 || page.size() == 1) {
                    continue;
                }
                stack.push(page.pop());
                map.put(page.peek(), map.getOrDefault(page.peek(), 0)+1);
            } else if (arr[i].equals("F")) {
                if(stack.size() == 0 || page.size() == 0) {
                    continue;
                }
                page.push(stack.pop());
                map.put(page.peek(), map.getOrDefault(page.peek(), 0)+1);
            }
        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) > answer) {
                answer = map.get(integer);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "1 10 B B 20 1 F B B";
        System.out.println(s.solution(str));
    }
}
