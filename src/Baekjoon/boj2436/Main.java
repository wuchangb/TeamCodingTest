package Baekjoon.boj2436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A,B;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        long AB = (long)A*B;
        long a = 0;
        long b = 0;
        long sum = Long.MAX_VALUE;
        for (int i = A; i <= Math.sqrt(AB); i+=A) {
            if (AB % i == 0 && func(i, AB / i) == A) {
                if (i + AB / i < sum) {
                    a = i;
                    b = AB / i;
                }
            }
        }
        sb.append(Math.min(a,b)).append(" ").append(Math.max(a,b));
        System.out.println(sb.toString());
    }

    static long func(long a, long b) {
        if (a % b == 0) {
            return b;
        } else {
            return func(b, a % b);
        }
    }
}
