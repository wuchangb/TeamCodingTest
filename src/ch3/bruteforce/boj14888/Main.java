package ch3.bruteforce.boj14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, MAX, MIN;
    static int[] nums;
    static int[] operator = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;
        nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        rec(1, nums[1]);

        sb.append(MAX).append("\n").append(MIN);
        System.out.println(sb);
    }

    public static void rec(int k, int value) {
        if (k == N) {
            MAX = Math.max(MAX, value);
            MIN = Math.min(MIN, value);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operator[i] >= 1) {
                    operator[i]--;
                    rec(k+1, calculate(value, i, nums[k+1]));
                    operator[i]++;
                }
            }
        }
    }

    public static int calculate(int value, int i, int value2) {
        if (i == 1) {
            return value += value2;
        }else if (i == 2) {
            return value -= value2;
        }else if (i == 3) {
            return value *= value2;
        } else {
            return value /= value2;
        }
    }
}
