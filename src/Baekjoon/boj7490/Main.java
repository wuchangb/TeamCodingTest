package Baekjoon.boj7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            dfs(1, "1");
            Collections.sort(list);
            for (String s : list) {
                sb.append(s).append("\n");
            }
            sb.append("\n");
            list = new ArrayList<>();
        }

        System.out.println(sb.toString());
    }

    static void dfs(int num, String str) {
        if (num == N) {
            String replace = str.replaceAll(" ", "");
            if (zero(replace)) {
                list.add(str);
            }
            return;
        }
        int next = num+1;
        dfs(next, str + " " + next);
        dfs(next, str + "+" + next);
        dfs(next, str + "-" + next);
    }

    static boolean zero(String str) {
        StringTokenizer st = new StringTokenizer(str, "+|-", true);
        int sum = Integer.parseInt(st.nextToken());
        while (st.hasMoreElements()) {
            String token = st.nextToken();
            if (token.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            } else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }
        if (sum == 0) {
            return true;
        } else return false;
    }
}
