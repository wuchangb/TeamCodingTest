package Baekjoon.boj2115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        int answer = 0;

        //윗벽
        for (int i = 1; i <= N - 2; i++) {
            int cnt = 0;
            for (int j = 1; j <= M - 2; j++) {
                if (graph[i - 1][j] == 'X' && graph[i][j] == '.') {
                    cnt++;
                } else {
                    answer += cnt / 2;
                    cnt = 0;
                }
            }
            answer += cnt / 2;
        }

        //아랫벽
        for (int i = 1; i <= N - 2; i++) {
            int cnt = 0;
            for (int j = 1; j <= M - 2; j++) {
                if (graph[i + 1][j] == 'X' && graph[i][j] == '.') {
                    cnt++;
                } else {
                    answer += cnt / 2;
                    cnt = 0;
                }
            }
            answer += cnt / 2;
        }

        //왼쪽벽
        for (int i = 1; i <= M - 2; i++) {
            int cnt = 0;
            for (int j = 1; j <= N - 2; j++) {
                if (graph[j][i - 1] == 'X' && graph[j][i] == '.') {
                    cnt++;
                } else {
                    answer += cnt / 2;
                    cnt = 0;
                }
            }
            answer += cnt / 2;
        }

        //오른쪽벽
        for (int i = 1; i <= M - 2; i++) {
            int cnt = 0;
            for (int j = 1; j <= N - 2; j++) {
                if (graph[j][i + 1] == 'X' && graph[j][i] == '.') {
                    cnt++;
                } else {
                    answer += cnt / 2;
                    cnt = 0;
                }
            }
            answer += cnt / 2;
        }

        System.out.println(answer);
    }
}
