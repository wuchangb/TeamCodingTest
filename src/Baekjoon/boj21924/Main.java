package Baekjoon.boj21924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//prim 알고리즘(MST)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        long sum = 0L;

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[to].add(new Node(from, weight));
            list[from].add(new Node(to, weight));

            sum += weight;
        }

        long min = 0L;
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.next]) continue;
            int to = node.next;
            int weight = node.price;

            visited[to] = true;
            min += weight;

            for (Node nod : list[to]) {
                if (!visited[nod.next]) {
                    queue.add(nod);
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) answer++;
        }

        if (answer > 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum - min);
        }

    }

    static class Node implements Comparable<Node> {

        int next;
        int price;

        public Node(int next, int price) {
            this.next = next;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return this.price - o.price;
        }
    }

}
