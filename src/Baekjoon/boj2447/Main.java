package Baekjoon.boj2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] graph;
    static int N;
    static int K = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new String[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = "*";
            }
        }

        int tmp = N;

        while (tmp > 1) {
            tmp /= 3;
            K++;
        }

        for (int i = 1; i <= K; i++) {
            erase(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static void erase(int num) {
        int tmp = 1;
        for (int i = 0; i < num; i++) {
            tmp *= 3;
        }

        int x = tmp/2 +1;
        int y = (tmp / 3) / 2;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i % tmp >= x - y && i % tmp <= x + y && j % tmp >= x - y && j % tmp <= x + y) {
                    graph[i][j] = " ";
                }
            }
        }
    }
}
