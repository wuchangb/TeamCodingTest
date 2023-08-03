package programmers.lv2.nx2타일링;

import java.util.*;
import java.io.*;

public class Solution2 {
    public int solution(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int answer = 1;
        int count = n/2;

        for(int i=1; i<=count; i++) {
            answer += cal(n-i, i);
        }

        return answer;
    }

    public int cal(int x, int y) {
        int a = 1;
        int b = 1;

        for(int i=0; i<y; i++) {
            a *= x-i;
        }

        for(int i=0; i<y; i++) {
            b *= y-i;
        }

        return a/b;
    }


}