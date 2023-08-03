package Baekjoon.boj1456;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max;
    static long A, B;
    static boolean[] notPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        max = 10000000;
        notPrime = new boolean[10000001];

        eratos();

        long count = 0;

            for (long i = 2; i <= max; i++) {
                if (notPrime[(int)i]) continue;
                long tmp = i * i;

                while (tmp <= B) {
                    if (tmp >= A) {
                        count++;
                    }
                    if (i > 100000) break;
                    tmp *= i;
                }
            }

        System.out.println(count);

    }

    static void eratos() {
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i <= max; i++) {
            if (notPrime[i]) continue;
            for (int j = i * 2; j <= max; j += i) {
                notPrime[j] = true;
            }
        }
    }
}
