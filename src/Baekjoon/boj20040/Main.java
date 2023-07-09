package Baekjoon.boj20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) != find(b)) {
                union(a, b);
            } else {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    static int find(int num) {
        if (parent[num] == num) {
            return num;
        } else {
            return parent[num] = find(parent[num]);
        }
    }

    static void union(int a, int b) {
        if (a < b) {
            parent[find(b)] = parent[find(a)];
        } else {
            parent[find(a)] = parent[find(b)];
        }
    }
}