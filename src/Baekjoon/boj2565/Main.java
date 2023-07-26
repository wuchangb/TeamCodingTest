package Baekjoon.boj2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static int N;
    static int[][] graph;
    static Integer[] dp;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][2];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            graph[i][0] = Integer.parseInt(s[0]);
            graph[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            answer = Math.max(func(i), answer);
        }

        System.out.println(N-answer);

    }

    static int func(int idx) {

        if (dp[idx] == null) {
            dp[idx] = 1;

            for (int i = idx+1; i < N; i++) {
                if (graph[idx][1] < graph[i][1]) {
                    dp[idx] = Math.max(dp[idx], func(i) + 1);
                }
            }
        }

        return dp[idx];
    }
}
