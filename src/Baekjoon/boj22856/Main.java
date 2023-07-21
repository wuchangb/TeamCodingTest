package Baekjoon.boj22856;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Node[] arr;
    static int similarCnt, visitedCnt;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            arr[cur] = new Node(left, right);
        }

        func(1);

        similarCnt = 0;
        similar(1);

    }

    static void func(int cur) {
        Node node = arr[cur];

        if (node.left != -1) {
            func(node.left);
        }

        list.add(cur);

        if (node.right != -1) {
            func(node.right);
        }
    }

    static void similar(int cur) {
        Node node = arr[cur];
        similarCnt++;

        if (!visited[cur]) {
            visited[cur] = true;
            visitedCnt++;
        }
        if (node.left != -1) {
            similar(node.left);
            similarCnt++;
        }
        if (node.right != -1) {
            similar(node.right);
            similarCnt++;
        }

        if (visitedCnt == N && cur == list.get(list.size()-1)) {
            System.out.println(similarCnt - 1);
        }

    }

    public static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
