package Baekjoon.boj1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int N, M;
    static ArrayList<Edge> list;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Edge(a, b, c));
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Collections.sort(list);

        int answer = 0;

        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);

            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                answer += edge.dist;
            }
        }

        System.out.println(answer);
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) {
            if (A > B) {
                parent[A] = B;
            } else {
                parent[B] = A;
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int dist;

        public Edge(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }

}
