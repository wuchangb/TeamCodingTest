package fastcampus_codingtest.firstTest.no4;

public class Solution {
    public long solution(int n, int[] goal) {
        long answer = -1;

        int[][] arr = new int[n+1][2];

        for (int i = 0; i < goal.length; i++) {
            for (int j = 0; j < Math.abs((i + 1) - goal[i]); j++) {
                if (i + 1 < goal[i]) {
                    arr[i + 1][1]++;
//                    arr[i + 2][0]++;
                } else {
                    arr[i+1][0]++;
//                    arr[i][1]++;
                }
            }
        }


        return answer;
    }
}
