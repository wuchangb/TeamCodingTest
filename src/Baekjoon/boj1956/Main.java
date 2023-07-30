package Baekjoon.boj1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int V, E, cnt, answer;
    static int[] parent;
    static ArrayList<Edge> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        parent = new int[V + 1];

        for (int i = 1; i <=V ; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            list.add(new Edge(a, b, c));
        }

        Collections.sort(list);
        answer = 0;

        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            if (find(edge.from) != find(edge.to)) {
                union(edge.to, edge.from);
                answer += edge.weight;
            }
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if (X >= Y) {
            parent[X] = Y;
        } else {
            parent[Y] = X;
        }
    }

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
