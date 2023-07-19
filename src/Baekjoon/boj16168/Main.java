package Baekjoon.boj16168;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int N,M, cnt;
    static ArrayList<Integer>[] list;
    static String answer = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            dfs(i,i,0);
        }
        System.out.println(answer);

    }

    static void dfs(int cur, int num, int cnt) {
        if (cnt == M) {
            answer = "YES";
            return;
        }

        for (Integer next : list[cur]) {
            if (graph[cur][next] == num || graph[next][cur] == num) {
                continue;
            }
            graph[cur][next] = graph[next][cur] = num;
            dfs(next, num, cnt + 1);
        }
    }

}
