package Baekjoon.boj1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] indeg;
    static int[] D;
    static int[] DSum;
    static ArrayList<Integer>[] list;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            indeg = new int[N + 1];
            D = new int[N + 1];
            DSum = new int[N + 1];
            list = new ArrayList[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                list[j] = new ArrayList<>();
                D[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                indeg[y]++;
            }

            queue = new LinkedList<>();

            for (int j = 1; j <= N; j++) {
                if (indeg[j] == 0) {
                    queue.add(j);
                    DSum[j] = D[j];
                }
            }

            while (!queue.isEmpty()) {
                Integer x = queue.poll();
                for (int y : list[x]) {
                    indeg[y]--;
                    if (indeg[y]==0) queue.add(y);
                    DSum[y] = Math.max(DSum[y], DSum[x] + D[y]);
                }
            }
            int answer = Integer.parseInt(br.readLine());
            sb.append(DSum[answer]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
