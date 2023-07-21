package Baekjoon.boj20007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M,X,Y, answer;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        visited = new boolean[N];
        min = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        dijkstra();

        Arrays.sort(min);

        int sum = 0;

        for (int i = 0; i < min.length; i++) {
            if (min[i] * 2 > X) {
                System.out.println(-1);
                return;
            }
            sum += min[i] * 2;

            if (sum > X) {
                answer++;
                sum = min[i] * 2;
            }
        }

        System.out.println(answer+1);
    }

    static void dijkstra() {
        Arrays.fill(min, Integer.MAX_VALUE);
        min[Y] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(Y, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Node next : list[node.idx]) {
                if (!visited[next.idx] && min[next.idx] > node.distance + next.distance) {
                    min[next.idx] = node.distance + next.distance;
                    pq.add(new Node(next.idx, min[next.idx]));
                }
            }

            visited[node.idx] = true;
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
