package Baekjoon.bruteForce.no10250;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int Y = 0;
            int X = 0;
            if (N / H == 0) {
                Y = H * 100;
                X = (N / H);
            } else {
                Y = N%H*100;
                X = (N/H)+1;
            }
            sb.append((X + Y)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
