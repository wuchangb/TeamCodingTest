package Baekjoon.boj5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            numbers = new String[N];

            for (int j = 0; j < N; j++) {
                numbers[j] = br.readLine();
            }
            Arrays.sort(numbers);

            if (func(N)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static boolean func(int N) {

        for (int i = 0; i < N - 1; i++) {
            if (numbers[i + 1].startsWith(numbers[i])) {
                return false;
            }
        }
        return true;
    }
}
