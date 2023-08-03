package Baekjoon.boj11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            if (maxHeap.size() == 0 && M == 0) {
                System.out.println(0);
            } else if (M == 0) {
                System.out.println(maxHeap.poll());
            } else {
                maxHeap.add(M);
            }
        }
    }
}
