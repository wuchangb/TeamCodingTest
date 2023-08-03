package Baekjoon.stack2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= num; i++) {
            int N = Integer.parseInt(st.nextToken());
            while (true) {
                if (!stack.isEmpty()) {
                    if (stack.peek() >= N) {
                        sb.append(index.peek() + " ");
                        stack.push(N);
                        index.push(i);
                        break;
                    } else {
                        stack.pop();
                        index.pop();
                    }

                } else {
                    sb.append("0 ");
                    stack.push(N);
                    index.push(i);
                    break;
                }
            }

        }
        System.out.println(sb);
    }
}
