package Baekjoon.boj2073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] dp = new int[D + 1];
        dp[0] = 8388608;

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            for (int j = D; j >= length; j--) {
                dp[j] = Math.max(dp[j], Math.min(capacity, dp[j - length]));
            }
        }

        System.out.println(dp[D]);
    }
}
