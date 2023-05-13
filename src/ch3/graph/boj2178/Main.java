package ch3.graph.boj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M, ANSWER;
    static int[] XX = {1, 0, -1,0};
    static int[] YY = {0, 1, 0, -1};
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        ANSWER = 0;
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= s.length(); j++) {
                graph[i][j] = s.charAt(j-1) - '0';
            }
        }

        bfs(1,1);
        System.out.println(ANSWER);


    }

    public static void bfs(int x, int y) {
        Queue<Graph> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Graph(x, y, 1));

        while (!queue.isEmpty()) {
            Graph gph = queue.poll();
            if (gph.x == N && gph.y == M) ANSWER = gph.count;
            for (int i = 0; i < 4; i++) {
                int X = gph.x + XX[i];
                int Y = gph.y + YY[i];
                if (X > 0 && Y > 0 && X <= N && Y <= M) {
                    if (graph[X][Y] == 1 && !visited[X][Y]) {
                        queue.add(new Graph(X, Y, gph.count+1));
                        visited[X][Y] = true;
                    }
                }
            }
        }
    }

    public static class Graph {
        int x;
        int y;
        int count;

        public Graph(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
