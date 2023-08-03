package programmers.lv1.no49;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr = new int[3];


        int countA = 0;
        int countB = 0;
        int countC = 0;
        int[] arrA = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] arrB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arrC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arrA[i % 10]) {
                countA++;
            }
            if (answers[i] == arrC[i % 10]) {
                countC++;
            }
            if (answers[i] == arrB[i % 8]) {
                countB++;
            }
        }
        arr[0]= countA;
        arr[1]= countB;
        arr[2]= countC;
        ArrayList<Integer> list = new ArrayList<>();
        int max = Math.max(arr[0], Math.max(arr[1], arr[2]));
        for (int i = 0; i < 3; i++) {
            if (arr[i] == max) {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);

        }
        return answer;
    }
}