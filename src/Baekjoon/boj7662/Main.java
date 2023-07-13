package Baekjoon.boj7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int T, K;
    static TreeMap<Integer, Integer> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            tree = new TreeMap<>();
            K = Integer.parseInt(br.readLine());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    tree.put(num, tree.getOrDefault(num, 0) + 1);
                } else {
                    if (tree.size() == 0) continue;
                    int key;
                    if (num == 1) {
                        key = tree.lastKey();
                    } else {
                        key = tree.firstKey();
                    }
                    if (tree.get(key) == 1) {
                        tree.remove(key);
                    } else {
                        tree.put(key, tree.get(key) - 1);
                    }
                }
            }

            if (tree.size() == 0) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(tree.lastKey()).append(" ").append(tree.firstKey()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
