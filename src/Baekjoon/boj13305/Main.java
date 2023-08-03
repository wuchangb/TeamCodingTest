package Baekjoon.boj13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] road = new long[N-1];
        long[] city = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < road.length; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city.length; i++) {
            city[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long cost = city[0];

        for (int i = 0; i < city.length - 1; i++) {
            if (city[i] < cost) {
                cost = city[i];
            }
            sum += cost * road[i];
        }


        System.out.println(sum);
    }
}
