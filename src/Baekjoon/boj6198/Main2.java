package Baekjoon.boj6198;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws Exception{
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long count = 0;

        int num = Integer.parseInt(br.readLine());
        for (int i = 1; i <= num; i++) {
            int temp = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= temp) {
                stack.pop();
            }
            stack.push(temp);
            count += stack.size()-1;
        }
        System.out.println(count);
    }
}
