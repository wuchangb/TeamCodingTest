package ch3.graph.boj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static boolean[][] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }
        dfs(V);
        sb.append("\n");
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        bfs(V);
        System.out.println(sb.toString());

    }

    public static void dfs(int index) {
        visited[index] = true;
        sb.append(index).append(" ");

        for (int i = 1; i <= N; i++) {
            if (graph[index][i] && !visited[i]) {
                dfs(i);
            }
        }

    }

    public static void bfs(int index) {
        visited[index] = true;
        que.add(index);
        while (!que.isEmpty()) {
            Integer poll = que.poll();
            sb.append(poll).append(" ");
            for (int i = 1; i <= N; i++) {
                if (graph[poll][i] && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
