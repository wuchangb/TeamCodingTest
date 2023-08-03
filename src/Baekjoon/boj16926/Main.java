package Baekjoon.boj16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,R, idx;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        idx = Math.min(N, M)/2;

        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            turn();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void turn() {

        for (int i = 1; i <= idx; i++) {
            int tmp = arr[N-i+1][i];

            for (int j = N-i+1; j >=i+1 ; j--) {
                arr[j][i] = arr[j-1][i];
            }

            for (int j = i; j <=M-i ; j++) {
                arr[i][j] = arr[i][j + 1];
            }

            for (int j = i; j <=N-i ; j++) {
                arr[j][M - i + 1] = arr[j + 1][M - i + 1];
            }

            for (int j = M-i+1; j >=i+2 ; j--) {
                arr[N - i + 1][j] = arr[N - i + 1][j - 1];
            }

            arr[N - i + 1][i + 1] = tmp;

        }
    }
}
