package Baekjoon.boj21923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M, max;
    static int[][] graph, dpUp, dpDown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = -100000000;
        graph = new int[N][M];
        dpUp = new int[N][M];
        dpDown = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        up();
        down();
        max();

        System.out.println(max);
    }

    static void up() {
        dpUp[N - 1][0] = graph[N - 1][0];

        for (int i = N-1; i >=0; i--) {
            if(i!=N-1) {
                dpUp[i][0] = dpUp[i+1][0] + graph[i][0];
            }
            for (int j = 1; j < M; j++) {
                if(i!=N-1) {
                    dpUp[i][j] = Math.max(dpUp[i+1][j], dpUp[i][j-1])+ graph[i][j];
                }
                else {
                    dpUp[i][j] =  dpUp[i][j-1] + graph[i][j];
                }
            }
        }
    }

    static void down() {
        dpDown[N-1][M-1] = graph[N-1][M-1];
        for (int i = N-1; i >=0; i--) {
            if(i!=N-1) {
                dpDown[i][M-1] = dpDown[i+1][M-1] + graph[i][M-1];
            }
            for (int j = M-2; j >=0; j--) {
                if(i!=N-1) {
                    dpDown[i][j] = Math.max(dpDown[i+1][j], dpDown[i][j+1])+ graph[i][j];
                }
                else {
                    dpDown[i][j] = dpDown[i][j+1] + graph[i][j];
                }
            }
        }
    }

    static void max() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(dpDown[i][j]+ dpUp[i][j] , max);
            }
        }
    }
}
