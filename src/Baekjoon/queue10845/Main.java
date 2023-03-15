package Baekjoon.queue10845;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int last = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push" :
                    last = Integer.parseInt(st.nextToken());
                    queue.add(last);
                    break;
                case "pop" :
                    if(queue.isEmpty()) {sb.append("-1").append("\n"); break;}
                    sb.append(queue.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    if(queue.isEmpty()) {sb.append("1").append("\n"); break;}
                    sb.append("0").append("\n");
                    break;
                case "front" :
                    if(queue.isEmpty()) {sb.append("-1").append("\n"); break;}
                    sb.append(queue.peek()).append("\n");
                    break;
                case "back" :
                    if(queue.isEmpty()) {sb.append("-1").append("\n"); break;}
                    sb.append(last).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
