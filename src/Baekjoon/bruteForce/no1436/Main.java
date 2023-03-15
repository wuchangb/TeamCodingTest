package Baekjoon.bruteForce.no1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int title = Integer.parseInt(br.readLine());
        int count = 0;
        boolean start = true;
        int i = 1;

        while (start) {
            i++;
            if (String.valueOf(i).contains("666")) {
                count++;
            }

            if (count == title) {
                start = false;
                break;
            }
        }
        System.out.println(i);
    }
}
