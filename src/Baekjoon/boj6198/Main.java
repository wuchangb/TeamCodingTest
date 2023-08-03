package Baekjoon.boj6198;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++) {
            int next = Integer.parseInt(br.readLine());
            queue.offer(next);
            index.offer(i);
        }

        while (true) {
            if (queue.size()==1) break;

            int fq = queue.poll();
            int iq = index.poll();
            for (int i = iq+1; i <= num; i++) {
                if (fq > queue.peek()) {
                    System.out.println("fq = "+fq);
                    System.out.println("queue,peek() = "+queue.peek());
                } else break;
            }
        }
        System.out.println(count);
    }
}
