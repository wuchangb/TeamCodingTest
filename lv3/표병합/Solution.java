package programmers.lv3.표병합;

import java.util.ArrayList;

class Solution {
    public String[] solution(String[] commands) {
        ArrayList<String> answerList = new ArrayList<>();
        Node[][] graph = new Node[51][51];
        int length = commands.length;
        for (int i = 0; i < length; i++) {
            String[] s = commands[i].split(" ");
            if (s[0].equals("UPDATE")) {
                if (s.length == 4) {
                    int r = Integer.parseInt(s[1]);
                    int c = Integer.parseInt(s[2]);
                    graph[r][c] = new Node(r, c, s[3]);
                } else {
                    for (int j = 1; j <=50 ; j++) {
                        for (int k = 1; k <=50 ; k++) {
                            if (graph[j][k] != null && graph[j][k].value.equals(s[1])) {
                                graph[j][k].value = s[2];
                            }
                        }
                    }
                }
            } else if (s[0].equals("MERGE")) {
                int r1 = Integer.parseInt(s[1]);
                int c1 = Integer.parseInt(s[2]);
                int r2 = Integer.parseInt(s[3]);
                int c2 = Integer.parseInt(s[4]);
                if (graph[r1][c1] != null && graph[r2][c2] == null) {
                    graph[r1][c1].list.add(new Node(r2, c2, graph[r1][c1].value));
                    graph[r2][c2] = new Node(r2, c2, graph[r1][c1].value);
                    graph[r2][c2].list.add(new Node(r1, c1, graph[r1][c1].value));
                } else if (graph[r2][c2] != null && graph[r1][c1] == null) {
                    graph[r2][c2].list.add(new Node(r1, c1, graph[r2][c2].value));
                    graph[r1][c1] = new Node(r1, c1, graph[r2][c2].value);
                    graph[r1][c1].list.add(new Node(r2, c2, graph[r2][c2].value));
                } else if(graph[r1][c1] != null && graph[r2][c2] != null){
                    graph[r1][c1].list.add(new Node(r2, c2, graph[r1][c1].value));
                    for (Node node : graph[r2][c2].list) {
                        graph[r1][c1].list.add(new Node(node.r, node.c, graph[r1][c1].value));
                    }
                    graph[r2][c2].value = graph[r1][c1].value;
                    for (int j = 0; j < graph[r2][c2].list.size(); j++) {

                    }
                    graph[r2][c2].list.add(new Node(r1, c1, graph[r1][c1].value));
                }
            } else if (s[0].equals("UNMERGE")) {
                int r = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                if (graph[r][c] == null) continue;
                for (Node node : graph[r][c].list) {
                    int r1 = node.r;
                    int c1 = node.c;
                    graph[r1][c1] = null;
                }
                graph[r][c].list = null;
            } else {
                int r = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                if (graph[r][c] == null) {
                    answerList.add("EMPTY");
                } else {
                    answerList.add(graph[r][c].value);
                }
            }
        }
        int size = answerList.size();
        String[] answer = new String[size];
        for (int i = 0; i < size; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    static class Node {
        int r;
        int c;
        String value;
        ArrayList<Node> list = new ArrayList<>();

        public Node(int r, int c, String value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        Solution s = new Solution();
        System.out.println(s.solution(commands)[0]);
    }
}