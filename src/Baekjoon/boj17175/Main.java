package Baekjoon.boj17175;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        func();

        System.out.println(dp[N]% 1000000007 );
    }

    static void func() {

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 50; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]+1;
        }
    }
}
