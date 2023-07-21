package Baekjoon.boj19949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, answer;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10];
        answer = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);

        System.out.println(res);

    }

    static void func(int idx, int count) {
        if (idx == 10) {
            if (count >= 5) {
                res++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (idx >= 2) {
                if (answer[idx - 2] == i && answer[idx - 1] == i) continue;
            }

            answer[idx] = i;
            if (arr[idx] == i) {
                func(idx + 1, count + 1);
            } else {
                func(idx + 1, count);
            }
        }

    }
}
