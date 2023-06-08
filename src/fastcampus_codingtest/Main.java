package fastcampus_codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String answer = recur(N);
        System.out.println(answer);
    }

    public static String recur(int N) {

        if (N <= 0) return "";

        N = N-1;

        return recur(N / 26) + (char)('A'+N % 26);
    }
}
