package Baekjoon.stack2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();


        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 1; i <= num; i++) {
            int next = Integer.parseInt(st.nextToken());
            stack.push(next);
        }

        for (int i = 1; i <= num; i++) {
            if (stack.isEmpty()) {
                break;
            }
            int p = stack.pop();
            for (int j = i; j <= num; j++) {
                Stack<Integer> stack2 = stack;
                if(stack2.size()==1){
                    sb.insert(0, 0);
                    break;
                }
                if (stack2.peek() > p) {
                    sb.insert(0, " ");
                    sb.insert(0, num - j);
                    break;
                } else {
                    stack2.pop();
                }
            }
        }
        System.out.println(sb);
    }
}
