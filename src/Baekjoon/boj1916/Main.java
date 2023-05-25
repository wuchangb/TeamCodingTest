package Baekjoon.boj1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            edges[x].add(new Edge(z, y));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (dist[node.idx] != node.dist) continue;

            for (Edge e : edges[node.idx]) {
                if (dist[node.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[node.idx] + e.weight;
                queue.add(new Node(e.to, dist[e.to]));
            }
        }
    }

    public static class Node {
        public int idx;
        public int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static class Edge {
        public int weight;
        public int to;

        public Edge(int weight, int to) {
            this.weight = weight;
            this.to = to;
        }
    }

}
