package Baekjoon.boj14284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m,s,t;
    static int[] dist;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        list = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        dij(s,t);
        System.out.println(dist[t]);
    }

    static void dij(int s, int t) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node next : list[now.next]) {
                if (dist[next.next] > dist[now.next] + next.distance) {
                    dist[next.next] = dist[now.next] + next.distance;
                    pq.add(new Node(next.next, dist[next.next]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {

        int next;
        int distance;

        public Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o1) {
            return this.distance - o1.distance ;
        }
    }

}
