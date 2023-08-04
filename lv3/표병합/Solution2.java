package programmers.lv3.표병합;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    static int[] parent = new int[2501];
    static String[] value = new String[2501];
    static List<String> answer = new ArrayList<>();

    public String[] solution(String[] commands) {
        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
            value[i] = "";
        }

        for (int i = 0; i < commands.length; i++) {
            String[] s = commands[i].split(" ");
            if (s[0].equals("UPDATE")) {
                if (s.length == 4) {
                    int r = Integer.parseInt(s[1]);
                    int c = Integer.parseInt(s[2]);
                    String str = s[3];
                    int index = getIndex(r, c);
                    value[find(index)] = str;
                } else {
                    String before = s[1];
                    String after = s[2];
                    for (int j = 1; j <= 2500; j++) {
                        if (value[j].equals(before)) {
                            value[j] = after;
                        }
                    }
                }
            } else if (s[0].equals("MERGE")) {
                int r1 = Integer.parseInt(s[1]);
                int c1 = Integer.parseInt(s[2]);
                int r2 = Integer.parseInt(s[3]);
                int c2 = Integer.parseInt(s[4]);
                int index1 = getIndex(r1, c1);
                int index2 = getIndex(r2, c2);
                String str;
                if (find(index1) == find(index2)) continue;
                if (value[find(index1)].equals("")) {
                    str = value[find(index2)];
                } else {
                    str = value[find(index1)];
                }
                value[find(index1)] = "";
                value[find(index2)] = "";
                union(find(index1), find(index2));
                value[find(index1)] = str;
            } else if (s[0].equals("UNMERGE")) {
                int r = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                int index = getIndex(r, c);
                String str = value[find(index)];
                value[find(index)] = "";
                value[index] = str;
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j <=2500 ; j++) {
                    if (find(j) == find(index)) {
                        list.add(j);
                    }
                }
                for (Integer integer : list) {
                    parent[integer] = integer;
                }
            } else if (s[0].equals("PRINT")){
                int r = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                int index = getIndex(r, c);
                if (value[index].equals("")) {
                    answer.add("EMPTY");
                } else {
                    answer.add(value[index]);
                }
            }
        }
        String[] result = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a >= b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    static int getIndex(int a, int b) {
        int answer = 0;
        answer += (a - 1) * 50;
        answer += b;
        return answer;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
        System.out.println(sol.solution(commands)[0]);
    }
}
