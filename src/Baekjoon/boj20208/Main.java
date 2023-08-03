package Baekjoon.boj20208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N,M,H, cnt;
    static int[][] graph;
    static boolean[] visited;
    static ArrayList<Point> list;
    static Point home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    home = new Point(i, j);
                }
                if (x == 2) {
                    list.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[list.size()];

        for (int i = 0; i < list.size(); i++) {
            Point cur = list.get(i);
            int distance = Math.abs(home.r - cur.r) + Math.abs(home.c - cur.c);

            if (distance <= M) {
                func(cur, i, M - distance + H, 1);
            }
        }

        System.out.println(cnt);
    }

    static void func(Point cur, int idx, int hp, int count) {
        visited[idx] = true;

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                Point next = list.get(i);
                int distance = Math.abs(cur.r - next.r) + Math.abs(cur.c - next.c);

                if (distance <= hp) {
                    func(next, i, hp - distance + H, count + 1);
                }
            }
        }

        int dist = Math.abs(cur.r - home.r) + Math.abs(cur.c - home.c);

        if (dist <= hp) {
            cnt = Math.max(cnt, count);
        }

        visited[idx] = false;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
