package Baekjoon.boj6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] arr;
    static boolean[] visited;
    static char[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            arr = br.readLine().toCharArray();
            Arrays.sort(arr);
            visited = new boolean[arr.length];
            output = new char[arr.length];

            dfs(0);
        }

        System.out.println(sb.toString());

    }

    static void dfs(int depth) {
        if (depth == arr.length) {
                sb.append(output).append("\n");
            return;
        }

        char lastUsed = '\u0000';  // null character
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && arr[i] != lastUsed) {
                visited[i] = true;
                output[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
                lastUsed = arr[i];
            }
        }
    }
}