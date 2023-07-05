package Baekjoon.boj20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int count = 0;
    static int[] arr;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (possible()) {
            count++;
            //1
            int tmp = arr[(2 * N) - 1];
            for (int i = (2 * N) - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            //2
            for (int i = N-1; i > 0 ; i--) {
                if (robot[i - 1] && !robot[i] && arr[i] > 0) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    arr[i]--;
                }
            }

            //3
            if (arr[0] > 0) {
                robot[0] = true;
                arr[0]--;
            }
        }

        System.out.println(count);

    }

    static boolean possible() {
        int count = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (arr[i] == 0) count++;
        }

        if (count >= K) return false;
        else return true;
    }
}
