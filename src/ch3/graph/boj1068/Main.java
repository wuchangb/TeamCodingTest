package ch3.graph.boj1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx == -1) continue;
            list[idx].add(i);
        }
        int num = Integer.parseInt(br.readLine());
        int minus= list[num].size()+1;

        for (int i = 0; i < list[num].size(); i++) {
            for (int j = 0; j < list[list[num].get(i)].size(); j++) {
                list[list[num].get(i)] = new ArrayList<>();
            }
        }

        list[num] = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if (list[i].size()==0) answer++;
        }

        System.out.println(answer-minus);
    }
}
