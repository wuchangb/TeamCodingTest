package programmers.lv2.게임맵최단거리fail;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] rowArr = {1, -1, 0, 0};
    int[] colArr = {0, 0, 1, -1};
    boolean visited[][];
    int rowL, colL;


    public int solution(int[][] maps) {

        visited = new boolean[maps.length][maps[0].length];
        return bfs(maps, 0, 0);
    }

    public int bfs(int[][] maps, int row, int col) {
        rowL = maps.length;
        colL = maps[0].length;

        Node node = new Node(row, col, 1);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (poll.row == rowL - 1 && poll.col == colL - 1) {
                return poll.count;
            }

            for (int i = 0; i < 4; i++) {
                int tmpRow = poll.row + rowArr[i];
                int tmpCol = poll.col + colArr[i];
                if (tmpRow < rowL && tmpCol < colL && tmpRow >= 0 && tmpCol >= 0) {
                    if (!visited[tmpRow][tmpCol] && maps[tmpRow][tmpCol] == 1) {
                        visited[tmpRow][tmpCol] = true;
                        q.add(new Node(tmpRow, tmpCol, poll.count + 1));
                    }
                }
            }
        }
        return -1;
    }


    public class Node {
        int row;
        int col;
        int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}