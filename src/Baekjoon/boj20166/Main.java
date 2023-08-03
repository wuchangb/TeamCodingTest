package Baekjoon.boj20166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] graph;
    static HashMap<String, Integer> map = new HashMap<>();
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};
    static String[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[N+1][M+1];
        list = new String[K + 1];

        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = tmp.charAt(j-1);
            }
        }

        for (int i = 1; i <= K; i++) {
            String str = br.readLine();
            list[i] = str;
            map.put(str, 0);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                String s = "";
                s += graph[i][j];
                dfs(i, j, 1, s);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= K; i++) {
            sb.append(map.get(list[i])).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int x, int y, int count, String s) {

        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        }
        if (count < 5) {
            for (int i = 0; i < 8; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if (X > N) X = 1;
                if (Y > M) Y = 1;
                if (X == 0) X = N;
                if (Y == 0) Y = M;
                dfs(X, Y, count + 1, s + graph[X][Y]);
            }
        }
    }
}
