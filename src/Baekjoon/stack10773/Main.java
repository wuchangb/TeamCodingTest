package Baekjoon.stack10773;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                stack.pop();
            }
            else {
                stack.push(command);
            }
        }
        int x = 0;
        while (!stack.isEmpty()) {
            x += stack.pop();
        }
        System.out.println(x);
    }
}
