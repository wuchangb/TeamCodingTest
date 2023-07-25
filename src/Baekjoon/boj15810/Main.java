package Baekjoon.boj15810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int arr[] = new int[N];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int second = 0;
        int cnt = 0;

        boolean flag = true;
        while (flag) {
            second++;
            for (int i = 0; i < N; i++) {
                if (second % arr[i] == 0) {
                    cnt++;
                }
                if (cnt == M) flag = false;
            }
        }

        System.out.println(second);
    }
}
