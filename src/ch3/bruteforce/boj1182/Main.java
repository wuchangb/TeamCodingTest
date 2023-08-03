package ch3.bruteforce.boj1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int answer = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        rec(1, 0);
        if (S == 0) answer--;
        System.out.println(answer);
    }

    static void rec(int k, int value) {
        if (k == N + 1) {
            if (value == S) {
                answer++;
            }
        } else {
            rec(k+1, value + arr[k]);
            rec(k+1, value);
        }
    }
}
