package Baekjoon.boj18114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == C) {
                System.out.println(1);
                return;
            }
            arr[i] = tmp;
            set.add(tmp);
        }

        for (int i = 1; i <= N; i++) {
            int weight = C - arr[i];
            if (set.contains(weight) && weight != arr[i]) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                int weight = C - arr[i] - arr[j];
                if (set.contains(weight) && weight != arr[i] && weight != arr[j]) {
                    System.out.println(1);
                    return;
                }
            }
        }

//        int L = 1;
//        int R = N;
//        int weight;
//
//        while (L <= R) {
//            weight = arr[L] + arr[R];
//            if (weight == C) {
//                System.out.println(1);
//                return;
//            } else if (weight > C) {
//                R--;
//            } else {
//                int remain = C - weight;
//                if (set.contains(remain) && remain != arr[L] && remain != arr[R]) {
//                    System.out.println(1);
//                    return;
//                }
//                L++;
//            }
//        }
        System.out.println(0);
    }
}