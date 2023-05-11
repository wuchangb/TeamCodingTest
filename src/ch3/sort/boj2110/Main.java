package ch3.sort.boj2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 1000000000;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right)/2;
            if (cal(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(answer);
    }

    static boolean cal(int num) {
        int count = 1;
        int last = arr[1];
        for (int i = 2; i <=N ; i++) {
            if (arr[i] - last >= num) {
                count++;
                last = arr[i];
            }
        }

        return count >= C;
    }
}
