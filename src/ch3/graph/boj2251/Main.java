package ch3.graph.boj2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] limit;
    static int[] bucket;
    static Set<Integer> answer;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = new int[3];
        bucket = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        answer = new HashSet<>();
        bfs();

        StringBuilder sb = new StringBuilder();

        for (int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void bfs() {
        Queue<Bucket> queue = new LinkedList<>();
        queue.add(new Bucket(new int[]{0, 0, limit[2]}));
        visited = new boolean[201][201];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Bucket poll = queue.poll();
            if (poll.tmp[0] == 0) answer.add(poll.tmp[2]);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i==j) continue;
                    Bucket next = poll.move(i, j);
                    if (!visited[next.tmp[0]][next.tmp[1]]) {
                        visited[next.tmp[0]][next.tmp[1]] = true;
                        queue.add(next);
                    }
                }
            }
        }
    }

    public static class Bucket {
        int[] tmp;

        public Bucket(int[] tmp) {
            this.tmp = new int[3];
            for (int i = 0; i < 3; i++) {
                this.tmp[i] = tmp[i];
            }
        }

        Bucket move(int from, int to) {
            int[] tmpBuc = {tmp[0], tmp[1], tmp[2]};
            if (tmp[from] + tmp[to] > limit[to]) {
                tmpBuc[from] -= limit[to] - tmpBuc[to];
                tmpBuc[to] = limit[to];
            } else {
                tmpBuc[from] = 0;
                tmpBuc[to] = tmp[from] + tmp[to];
            }
            return new Bucket(tmpBuc);
        }
    }
}
