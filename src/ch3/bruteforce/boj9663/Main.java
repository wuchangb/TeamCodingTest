package ch3.bruteforce.boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int answer = 0;
    static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N + 1];
        rec(1);
        System.out.println(answer);
    }

    public static void rec(int row) {
        if (row == N + 1) {
            answer++;
        } else {
            for (int i = 1; i <= N; i++) {
                boolean possible = true;
                for (int j = 1; j <= row - 1; j++) {
                    if (attackable(row, i, j, col[j])) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    col[row] = i;
                    rec(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        return false;
    }
}
