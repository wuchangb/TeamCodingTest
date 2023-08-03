package Baekjoon.boj9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long answer = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    answer += euclid(arr[j], arr[k]);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());

    }

    static int euclid(int a, int b) {
        int A = Math.max(a, b);
        int B = Math.min(a, b);

        if (A % B == 0) {
            return B;
        } else {
            return euclid(B, A % B);
        }
    }
}
