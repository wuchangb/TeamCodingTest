package Baekjoon.boj5427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int row, col, cnt;
    public Node(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class Main {
    public static final int[] dx = {1,0,-1,0};
    public static final int[] dy = {0,1,0,-1};
    public static int N,M,ans;
    public static boolean[][] visit;
    public static char[][] map;
    public static Queue<Node> q;
    public static Queue<Node> fireQ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            visit = new boolean[N][M];
            q = new LinkedList<>();
            fireQ = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                char[] ch = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = ch[j];
                    if		(map[i][j] == '*') fireQ.add(new Node(i,j));
                    else if (map[i][j] == '@') q.add(new Node(i,j,0));
                }
            }
            ans = 0;
            bfs();
            if(ans == 0) System.out.println("IMPOSSIBLE");
            else  	     System.out.println(ans);
        }
    }
    public static void bfs() {

        int size = 0;
        while(!q.isEmpty()) {
            size = fireQ.size();
            for (int f = 0; f < size; f++) {
                Node fire = fireQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = fire.row + dx[i];
                    int ny = fire.col + dy[i];

                    if((nx<0 || nx >=N || ny <0 || ny>= M)) {
                        continue;
                    }

                    if(map[nx][ny] == '.' || map[nx][ny] == '@') {
                        map[nx][ny] = '*';
                        fireQ.add(new Node(nx,ny));
                    }
                }
            }
            size = q.size();
            for (int h = 0; h < size; h++) {
                Node pos = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = pos.row + dx[i];
                    int ny = pos.col + dy[i];

                    if((nx<0 || nx >=N || ny <0 || ny>= M)) {
                        ans = pos.cnt+1;
                        return;
                    }

                    if(map[nx][ny] == '.') {
                        map[nx][ny] = '@';
                        q.add(new Node(nx,ny,pos.cnt+1));
                    }
                }
            }
        }
    }
}