package ch3.binarysearch.boj2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int A = 0;
        int B = 0;

        for (int i = 0; i < N; i++) {
            int cand = search(arr, i + 1, arr.length - 1, -arr[i]);
//            if (cand > i && )
        }

        StringBuilder sb = new StringBuilder();
        sb.append(A).append(' ').append(B);
        System.out.println(sb.toString());
    }

    public static int search(int[] arr, int L, int R, int X) {
        //X보다 큰 인덱스 중 가장 왼쪽 찾기
        int answer = 0;
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= X) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
