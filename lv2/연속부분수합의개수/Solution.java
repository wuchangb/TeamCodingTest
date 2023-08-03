package programmers.lv2.연속부분수합의개수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k <i; k++) {
                    if (j + k > elements.length - 1) {
                        sum += elements[(j + k) % elements.length];
                    } else {
                        sum += elements[j+k];
                    }
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}