package Baekjoon.boj18513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, cnt;
    static long answer;
    static HashSet<Integer> set = new HashSet<>();
    static Queue<Node> queue;
    static int[] dx = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            queue.add(new Node(tmp, 0));
            set.add(tmp);
        }

        bfs();
        System.out.println(answer);
    }

    static void bfs() {

        while (!queue.isEmpty()) {
            if (cnt == K) return;
            Node node = queue.poll();
            for (int i = 0; i < 2; i++) {
                int x = dx[i] + node.idx;
                if (set.contains(x)) continue;
                set.add(x);
                queue.add(new Node(x, node.dist + 1));
                answer += node.dist + 1;
                cnt++;
                if (cnt == K) return;
            }
        }
    }

    public static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

}
