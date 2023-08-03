package programmers.lv1.no40;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int x = commands[i][1] - commands[i][0];
            int y = commands[i][2];
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= x; j++) {

                list.add(array[commands[i][0]-1+j]);
                Collections.sort(list);
            }
            answer[i] = list.get(y-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        int[] answer = new int[commands.length];
        solution.solution(array, commands);
    }
}