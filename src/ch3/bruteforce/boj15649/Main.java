package ch3.bruteforce.boj15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];

        rec_func(1);
        System.out.println(sb.toString());

    }

    static public void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                boolean used = false;
                for (int j = 1; j < k; j++) {
                    if (i == selected[j]) {
                        used = true;
                    }
                }
                if (!used) {
                    selected[k] = i;
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }
}
