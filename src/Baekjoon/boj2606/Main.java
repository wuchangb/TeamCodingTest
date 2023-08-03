package Baekjoon.boj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] graph = new boolean[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = true;
        }

        int result = dfs(1, graph, visited);

        System.out.println(result);
    }

    public static int dfs(int v, boolean[][] graph, boolean[] visited) {
        visited[v] = true;
        int count = 0;

        for (int i = 1; i < graph.length; i++) {
            if (graph[v][i] && !visited[i]) {
                count += dfs(i, graph, visited) +1;
            }
        }
        return count;
    }
}
