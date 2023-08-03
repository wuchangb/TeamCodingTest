package Baekjoon.boj1254;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (func(str.substring(i))) {
                System.out.println(length);
                break;
            } else {
                length++;
            }
        }
    }

    static boolean func(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
