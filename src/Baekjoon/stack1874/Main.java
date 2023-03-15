package Baekjoon.stack1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        boolean no = false;

        for (int i = 0; i < num; i++) {
            int brR = Integer.parseInt(br.readLine());
            for (int j = count + 1; j <= brR; count++) {
                stack.push(j);
                sb.append("+").append("\n");
            }
            if (stack.peek() == brR) {
                stack.pop();
                sb.append("-").append("\n");

            } else {
                no = true;
            }

        }
        if (no) {
            System.out.println("NO");
        }
        System.out.println(sb);
    }
}

