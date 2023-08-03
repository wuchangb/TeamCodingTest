package programmers.lv1.no63;

import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int[] moveArr = new int[moves.length];
        for (int i = 0; i < moves.length; i++) {
            moveArr[i] = moves[i]-1;
        }

        for (int i = 0; i < moveArr.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moveArr[i]] != 0) {
                    if (list.size() == 0) {
                        list.add(board[j][moveArr[i]]);
                    }
                    else if (list.get(list.size() - 1).equals(board[j][moveArr[i]])) {
                        list.remove(list.size() - 1);
                        answer++;
                    } else {
                        list.add(board[j][moveArr[i]]);
                    }
                    board[j][moveArr[i]]=0;
                    break;
                }
            }
        }
        return answer;
    }
}