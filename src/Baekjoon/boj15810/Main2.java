package Baekjoon.boj15810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N];
        int min = Integer.MAX_VALUE;
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
            min = Math.min(min, arr[i]);
        }

        Arrays.sort(arr);
        long max = (long) min * (long) M;

        System.out.println(search(0, max));

    }

    static long search(long left, long right) {
        while (left <= right) {
            long mid = (left + right) / 2;
            long balloon = 0;
            for (int i = 0; i < N; i++) {
                balloon += mid / (long)arr[i];
            }
            if (balloon < M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
