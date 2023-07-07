package Baekjoon.boj7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N, H, count;
    static int[][][] graph;
    static int mArr[] = {-1, 0, 1, 0, 0, 0};
    static int nArr[] = {0, 1, 0, -1, 0, 0};
    static int hArr[] = {0, 0, 0, 0, 1, -1};
    static Queue<Tomato> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new int[M+1][N+1][H+1];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= M; k++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    graph[k][j][i] = tmp;
                    if (tmp == 1) {
                        queue.add(new Tomato(k, j, i));
                    }
                }
            }
        }

        BFS();
        System.out.println(count);
    }

    static void BFS() {

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for (int i = 0; i < 6; i++) {
                int mm = tomato.m + mArr[i];
                int nn = tomato.n + nArr[i];
                int hh = tomato.h + hArr[i];

                if (possible(mm, nn, hh)) {
                    queue.add(new Tomato(mm, nn, hh));
                    graph[mm][nn][hh] = graph[tomato.m][tomato.n][tomato.h]+1;
                }
            }
        }

        count = Integer.MIN_VALUE;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= H; k++) {
                    if (graph[i][j][k] == 0) {
                        count = -1;
                        return;
                    }
                    count = Math.max(count, graph[i][j][k]);
                }
            }
        }

        count -= 1;
    }

    static boolean possible(int m, int n, int h) {
        if (m == 0 || m > M || n == 0 || n > N || h == 0 || h > H) {
            return false;
        }
        if (graph[m][n][h] == 0) {
            return true;
        }
        return false;
    }


    static class Tomato {
        int m;
        int n;
        int h;

        public Tomato(int m, int n, int h) {
            this.m = m;
            this.n = n;
            this.h = h;
        }
    }
}
