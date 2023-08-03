package Baekjoon.stack10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push" :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if(stack.isEmpty()){sb.append("-1").append("\n"); break;}
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size" :
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty" :
                    if(stack.isEmpty()){sb.append("1").append("\n"); break;}
                    sb.append("0").append("\n");
                    break;
                case "top" :
                    if(stack.isEmpty()){sb.append("-1").append("\n"); break;}
                    sb.append(stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
