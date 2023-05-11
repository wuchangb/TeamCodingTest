package ch3.sort.boj11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();


        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        long answer = 0;
        for (Long x : map.keySet()) {
            if (map.get(x) > max) {
                max = map.get(x);
                answer = x;
            } else if (map.get(x) == max) {
                answer = answer < x ? answer : x;
            }
        }
        System.out.println(answer);
    }
}
