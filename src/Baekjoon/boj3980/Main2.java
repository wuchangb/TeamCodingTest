package Baekjoon.boj3980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

    static int answer;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < C; i++) {
            graph = new int[11][11];
            visited = new boolean[11];
            answer = Integer.MIN_VALUE;

            StringTokenizer st;
            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int idx, int score) {
        if (idx == 11){
            answer = Math.max(answer, score);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (!visited[i] && graph[idx][i] != 0) {
                visited[i] = true;
                dfs(idx + 1, score + graph[idx][i]);
                visited[i] = false;
            }
        }
    }
}
