package Baekjoon.boj14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int graph[][];
    static boolean visited[][];
    static int N, M, answer;
    static int[] dm = {0, 1, 0, -1};
    static int[] dn = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int startN = Integer.parseInt(st.nextToken());
        int startM = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer++;
        dfs(startN, startM, startD);
        System.out.println(answer);
    }

    static void dfs(int n, int m, int d) {
        visited[n][m] = true;

        for (int i = 0; i < 4; i++) {
            d = getDir(d);
            int nn = n + dn[d];
            int mm = m + dm[d];
            if (nn>=0 && nn<N && mm>=0 && mm<M && graph[nn][mm] == 0 && !visited[nn][mm]) {
                answer++;
                dfs(nn, mm, d);
                return;
            }
        }

        int nn = n - dn[d];
        int mm = m - dm[d];
        if (nn >= 0 && nn < N && mm >= 0 && mm < M && graph[nn][mm] == 0) {
            dfs(nn, mm, d);
        }
    }

    static int getDir(int d) {
        if (d == 0) return 3;
        else return d - 1;
    }
}
