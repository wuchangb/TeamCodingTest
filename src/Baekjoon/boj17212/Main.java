package Baekjoon.boj17212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int answer;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        answer = 0;
        dp = new int[100001];
        Arrays.fill(dp, 100000);
        calculate(N);

    }

    static void calculate(int number) {

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;

        for (int i = 8; i <= 100000; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            dp[i] = Math.min(dp[i], dp[i - 7] + 1);
        }

        System.out.println(dp[number]);
    }
}
