package Baekjoon.boj1487;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int idx = 0;
        int[] max = new int[N + 1];
        int[] delivery = new int[N + 1];
        int maxPrice = 0;

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            max[i] = tmp;
            maxPrice = Math.max(maxPrice, tmp);
            delivery[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= maxPrice; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if (i <= max[j] && i > delivery[j]) {
                    tmp += i;
                    tmp -= delivery[j];
                }
            }
            if (tmp > sum) {
                sum = tmp;
                idx = i;
            }
        }

        System.out.println(idx);
    }
}
