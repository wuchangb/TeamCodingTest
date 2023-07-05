package Baekjoon.boj15886;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int present = 1;

        Stack<Character> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String road = st.nextToken();

        for (int i = 0; i < N; i++) {
        }

        stack.push(road.charAt(0));

        for (int i = 1; i < N; i++) {
            Character peek = stack.peek();
            if (road.charAt(i) == 'E' && peek == 'W') {
                present++;
            }
            stack.push(road.charAt(i));
        }

        System.out.println(present);

    }
}
