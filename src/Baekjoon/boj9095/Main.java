package Baekjoon.boj9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] dy = new int[12];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for (int i = 4; i <= 11 ; i++) {
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dy[num]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
