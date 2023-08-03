package Baekjoon.boj1922;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Node>[] list;
    static int[] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        min = new int[N + 1];

        for (int i = 1; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        Arrays.fill(min, Integer.MAX_VALUE);
        min[1] = 0;
        dij();

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += min[i];
        }

        System.out.println(answer);
    }

    static void dij() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : list[cur.idx]) {
                if (min[next.idx] > min[cur.idx] + next.dist) {
                    min[next.idx] = min[cur.idx] + next.dist;
                    pq.add(new Node(next.idx, next.dist));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
