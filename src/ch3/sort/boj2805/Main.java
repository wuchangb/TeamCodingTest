package ch3.sort.boj2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = 2000000000;
        int answer = 0;

        while (left <= right) {
            int mid = (left+right)/2;
            if (cal(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(answer);

        }
    public static boolean cal(int mid){
        long sum = 0L;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                sum += arr[i] - mid;
            }
        }
        return sum >= M;
    }
}
