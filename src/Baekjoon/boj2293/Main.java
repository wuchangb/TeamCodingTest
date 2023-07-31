package Baekjoon.boj2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n,k;
    static int[] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        dp = new int[k + 1];
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
        }

        dp();

        System.out.println(dp[k]);
    }

    static void dp() {

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - arr[i] >= 0) {
                    dp[j] = dp[j] + dp[j - arr[i]];
                }
            }
        }
    }
}
