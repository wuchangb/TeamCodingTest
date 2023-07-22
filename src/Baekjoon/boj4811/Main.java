package Baekjoon.boj4811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long cnt = 0;
    public static long dp[][];
    public static int n;

    //dp[한알 개수][반알 개수]

    public static long medicine(int one, int half) {
        if (one == 0) {
            return 1;
        }
        if (dp[one][half] != 0) {
            return dp[one][half];
        }

        long cnt = 0;

        if (one != 0) {
            cnt += medicine(one - 1, half + 1);
        }
        if (half != 0) {
            cnt += medicine(one, half - 1);
        }

        return dp[one][half] = cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[31][31];

        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[3][0] = 5;
        medicine(30, 0);
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            } else {
                System.out.println(dp[n][0]);
            }
        }
    }
}
