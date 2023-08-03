package Baekjoon.boj21919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] notPrime;
    static int N;
    static long sum;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int max = 0;
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            max = Math.max(max, tmp);
            arr[i] = tmp;
        }
        notPrime = new boolean[max + 1];
        eratos();

        for (int i = 1; i <= N; i++) {
            if (!notPrime[arr[i]]) {
                list.add(arr[i]);
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }

        sum = list.get(0) * list.get(1) / euclid(list.get(0), list.get(1));

        for (int i = 2; i < list.size(); i++) {
            sum = sum * list.get(i) / euclid(sum, list.get(i));
        }

        System.out.println(sum);
    }

    static void eratos() {
        notPrime[0] = true;
        notPrime[1] = true;

        for (int i = 2; i*i < notPrime.length; i++) {

            if (!notPrime[i]) {
                for (int j = i * 2; j < notPrime.length; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }

    static long euclid(long a, long b) {
        long A, B;

        if (a >= b) {
            A = a;
            B = b;
        } else {
            A = b;
            B = a;
        }

        if (A%B == 0) return B;
        else return euclid(B, A % B);
    }
}
