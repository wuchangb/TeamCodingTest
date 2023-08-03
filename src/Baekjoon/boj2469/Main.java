package Baekjoon.boj2469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int k, n, q;
    static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    static String[] answer, start;
    static ArrayList<String[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        answer = new String[k];
        start = new String[k];

        for (int i = 0; i < k; i++) {
            start[i] = alphabet[i];
        }

        answer = br.readLine().split("");

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");
            if (arr[0].equals("?")) {
                q = i;
            }
            list.add(arr);
        }

        for (int i = 0; i < q; i++) {
            String[] arr = list.get(i);
            for (int j = 0; j < k-1; j++) {
                if (arr[j].equals("-")) {
                    swap(start, j,j+1);
                }
            }
        }

        for (int i = n-1; i > q; i--) {
            String[] arr = list.get(i);
            for (int j = 0; j < k - 1; j++) {
                if (arr[j].equals("-")) {
                    swap(answer,j,j+1);
                }
            }
        }

        String res = "";
        for (int i = 0; i < k - 1; i++) {
            if (start[i].equals(answer[i])) {
                res += "*";
                continue;
            } else if (start[i].equals(answer[i + 1])) {
                swap(start, i, i + 1);
                res += "-";
                continue;
            } else {
                res = "";
                for (int j = 0; j < k - 1; j++) {
                    res += "x";
                }
                break;
            }

        }

        System.out.println(res);
    }

    static void swap(String[] arr, int a, int b) {
        String tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
