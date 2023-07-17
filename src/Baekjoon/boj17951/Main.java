package Baekjoon.boj17951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int left, right, N, K, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        left = 0;
        right = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            right += tmp;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                min = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(min);
    }

    static boolean check(int num) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum >= num) {
                cnt++;
                sum = 0;
            }
        }
        return cnt >= K;
    }
}
