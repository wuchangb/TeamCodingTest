package Baekjoon.boj16195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N,M;
        StringBuilder sb = new StringBuilder();
        dp = new long[1001][1001];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        func();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            long sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += dp[N][j];
            }
            sum = sum % 1000000009;
            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());

    }

    static void func() {
        for (int i = 4; i <= 1000; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1])%1000000009;
            }
        }
    }

}
