package Baekjoon.boj11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer[] coins = new Integer[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins, Collections.reverseOrder());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (M >= coins[i]) {
                answer += M / coins[i];
                M = M % coins[i];
                if (M == 0) {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
