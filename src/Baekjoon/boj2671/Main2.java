package Baekjoon.boj2671;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();

        boolean flag = false;
        String answer = "SUBMARINE";
        int i = 0;
        while(i < sound.length()) {
            if (!flag) {
                if (sound.charAt(i) == '1') {
                    if (i + 1 >= sound.length() || sound.charAt(i + 1) == '1') {
                        answer = "NOISE";
                        break;
                    }
                    flag = true;
                } else {
                    if (i + 1 >= sound.length() || sound.charAt(i + 1) == '0') {
                        answer = "NOISE";
                        break;
                    }
                }
                i += 2;
            } else {
                boolean check = false;  //0이 반복되는지 체크
                while (i < sound.length()) {
                    if (sound.charAt(i) == '1') break;
                    check = true;
                    i++;
                }

                if (i >= sound.length() || !check) {
                    answer = "NOISE";
                    break;
                }

                check = false;  //1이 반복되는지 체크
                while (i < sound.length()) {
                    if (sound.charAt(i) == '0') break;
                    if(check && i + 1 < sound.length() && i + 2 < sound.length() && sound.charAt(i+1) == '0' && sound.charAt(i+2) == '0') break;
                    check = true;
                    i++;
                }
                flag = false;
            }
        }

        System.out.println(answer);

    }
}