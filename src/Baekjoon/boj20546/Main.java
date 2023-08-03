package Baekjoon.boj20546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[14];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = bnp(money);
        int b = timing(money);

        if (a > b) {
            System.out.println("BNP");
        } else if (a < b) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }

    }

    static int bnp(int money) {
        int cnt = 0;
        for (int i = 0; i < 14; i++) {
            if (money >= arr[i]) {
                cnt += money / arr[i];
                money -= arr[i] * cnt;
            }
        }

        return (cnt * arr[13]) + money;
    }

    static int timing(int money) {
        int cnt=0;
        int plus=0;
        int minus=0;

        for (int i = 1; i < 14; i++) {
            if (arr[i] > arr[i - 1]) {
                plus++;
                minus = 0;
            } else if (arr[i] < arr[i - 1]) {
                minus++;
                plus = 0;
            } else {
                plus = 0;
                minus = 0;
            }

            if (plus >= 3 && cnt > 0) {
                money += arr[i] * cnt;
                cnt = 0;
            }

            if (minus >= 3 && money >= arr[i]) {
                cnt += money / arr[i];
                money -= arr[i] * (money/arr[i]);
            }
        }

        return (cnt * arr[13]) + money;
    }
}
