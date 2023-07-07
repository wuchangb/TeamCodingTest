package Baekjoon.boj2671;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String sound, answer;
    static int length, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sound = br.readLine();
        length = sound.length();
        idx = 0;
        answer = "SUBMARINE";
        while (idx < length) {
            if (sound.charAt(idx) == '1') {
                if (!first(idx)) {
                    answer = "NOISE";
                    break;
                }
            } else {
                if (!second(idx)) {
                    answer = "NOISE";
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean first(int index) {

        if (index + 2 >= length || sound.charAt(index + 1) == '1' || sound.charAt(index + 2) == '1') {
            return false;
        }
        idx = index + 2;
        for (int i = index + 3; i < length; i++) {
            idx++;
            if (sound.charAt(i - 1) == '1' && sound.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }

    static boolean second(int index) {
        if (index + 2 > length) {
            idx = length + 1;
            answer = "NOISE";
        }
        if (index + 1 >= length || sound.charAt(index + 1) == '0') {
            return false;
        } else {
            idx += 2;
            return true;
        }
    }
}
