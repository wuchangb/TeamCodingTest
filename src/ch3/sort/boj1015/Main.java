package ch3.sort.boj1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Elem[] B = new Elem[N];
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].num = Integer.parseInt(st.nextToken());
            B[i].idx = i;
        }
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }

        System.out.println(sb.toString());

    }

    static class Elem implements Comparable<Elem> {
        int idx;
        int num;
        @Override
        public int compareTo(Elem o) {
            return num - o.num;
        }
    }

}
