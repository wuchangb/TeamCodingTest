package Baekjoon.boj15270;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, max, cnt;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

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

        max = Integer.MIN_VALUE;
        dfs(1, 1);

        if (max > N) max--;
        System.out.println(max);
    }

    static void dfs(int idx, int cnt) {
        if (idx >= N) {
            max = Math.max(max, cnt);
            return;
        }

        if (visited[idx]) {
            dfs(idx + 1, cnt);
        } else {
            visited[idx] = true;
            for (Integer next : list[idx]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dfs(idx + 1, cnt + 2);
                    visited[next] = false;
                }
            }
            visited[idx] = false;
            dfs(idx + 1, cnt);
        }
    }
}
