package Baekjoon.boj1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N+1][M+1];
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + graph[i][j];
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (graph[i][j] == 1) {
                    int res = 1;
                    int idx = 1;
                    while (i + idx <= N && j + idx <= M) {
                        int space = dp[i + idx][j + idx] - dp[i - 1][j + idx] - dp[i + idx][j - 1] + dp[i - 1][j - 1];
                        idx++;
                        if (space != idx * idx) break;
                        res = idx * idx;
                    }

                    answer = Math.max(answer, res);
                }
            }
        }

        System.out.println(answer);



    }
}
