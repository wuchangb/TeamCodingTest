package Baekjoon.boj1166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,L,W, H;
    static double min, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        min = Math.min(L, Math.min(W, H));

        answer = search(0, min);
        System.out.println(answer);
    }

    static double search(double start, double end) {

        while (start < end) {
            double mid = (start + end) / 2;
            if (cal(mid) < N) {
                if (end == mid) break;
                end = mid;
            } else {
                if (start == mid) break;
                start = mid;
            }
        }

        return start;
    }

    static long cal(double x) {
        return (long)(L / x) * (long)(W / x) * (long)(H / x);
    }
}
