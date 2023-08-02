package Baekjoon.boj2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int first = 1;
        int last = arr[N-1]-arr[0];

        int ans = search(first, last);
        System.out.println(ans);

    }

    static int search(int first, int last) {
        int answer = 0;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (determination(mid)) {
                answer = mid;
                first = mid + 1;
            } else {
                last = mid -1;
            }
        }

        return answer;
    }


    //거리가 주어지면, 그 거리만큼 공유기 거리 띄워서 설치했을 때 C 이상 설치되는지 여부
    static boolean determination(int dist) {
        int cnt = 1;
        int cur = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - cur >= dist) {
                cnt++;
                cur = arr[i];
            }
        }

        return cnt >= C;
    }
}
