package Baekjoon.boj1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main2 {

    static int V, E;
    static final int max = 1000000000;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        graph = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i==j) continue;
                graph[i][j] = max;
            }
        }

        for (int i = 0; i < E; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            graph[a][b] = c;
        }

        /**
        플로이드 -와샬 알고리즘 (
         */
        for (int i = 1; i <=V ; i++) {
            for (int j = 1; j <=V ; j++) {
                for (int k = 1; k <=V ; k++) {
                    if (j==k) continue;
                    if (graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        int answer = max;

        for (int i = 1; i <=V ; i++) {
            for (int j = 1; j <=V ; j++) {
                if (i==j) continue;
                if (graph[i][j] != max && graph[j][i] != max) {
                    answer = Math.min(answer, graph[i][j] + graph[j][i]);
                }
            }
        }

        if (answer == max) System.out.println(-1);
        else System.out.println(answer);

    }
}
