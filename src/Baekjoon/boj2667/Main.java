package Baekjoon.boj2667;

import java.io.IOException;
import java.util.*;

public class Main {
    static int[] ax = {1, 0, -1, 0};//우하좌상
    static int[] ay = {0, 1, 0, -1};
    static boolean visited[][];
    static int map[][];

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer>apart=new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input=sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    apart.add(BFS(i, j));
                    count++;
                }
            }
        }
        Collections.sort(apart);
        System.out.println(count);
        for (int i:apart) {
            System.out.println(i);
        }
    }

    private static int BFS(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));

        visited[i][j] = true;
        int number=1; //처음 들어온 숫자도 있으니까 1부터 시작
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = now.x + ax[k];
                int nextY = now.y + ay[k];
                if (nextX >= 0 && nextY >= 0 && nextX < visited.length && nextY < visited.length){
                    if(!visited[nextX][nextY]){
                        if(map[nextX][nextY]==1){
                            queue.add(new Node(nextX,nextY));
                            visited[nextX][nextY]=true;
                            number++;
                        }
                    }
                }
            }
        }
        return number;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}