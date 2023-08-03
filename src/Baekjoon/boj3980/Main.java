package Baekjoon.boj3980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int answer;
    static boolean[] visited;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            list = new ArrayList[11];
            visited = new boolean[11];
            answer = Integer.MIN_VALUE;
            for (int j = 0; j < 11; j++) {
                list[j] = new ArrayList<>();
            }
            StringTokenizer st;
            for (int j = 0; j < 11; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    int score = Integer.parseInt(st.nextToken());
                    if (score != 0) {
                        list[j].add(new Node(k, score));
                    }
                }
            }

            dfs(0,0);
            System.out.println(answer);
        }
    }

    static void dfs(int idx, int score) {
        if (idx == 11){
            answer = Math.max(answer, score);
            return;
        }

        for (Node node : list[idx]) {
            if (!visited[node.idx]) {
                visited[node.idx] = true;
                dfs(idx + 1, score + node.score);
                visited[node.idx] = false;
            }
        }


    }
    static class Node {
        int idx;
        int score;

        public Node(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }
}
