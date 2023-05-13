package ch3.binarysearch.boj7795;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N + 1];
            B = new int[M + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);

            for (int j = 0; j < N; j++) {
                answer += search(B, 1, M, A[j]);
            }
            System.out.println(answer);
        }
    }

    static int search(int[] A, int L, int R, int X) {
        int res = L-1;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < X) {
                res = mid;
                L = mid+1;
            } else {
                R = mid-1;
            }
        }
        return res;
    }
}
