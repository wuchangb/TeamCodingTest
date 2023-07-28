package Baekjoon.boj2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, x, y, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        sum = Integer.MAX_VALUE;
        search(0, N - 1);

        System.out.println(x + " " + y);
    }

    static void search(int left, int right) {

        while (left < right) {
            int tmp = Math.abs(arr[left] + arr[right]);
            if (tmp < sum) {
                x = arr[left];
                y = arr[right];
                sum = tmp;
                if (tmp == 0) break;
            }
            if (arr[left] + arr[right] > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}
