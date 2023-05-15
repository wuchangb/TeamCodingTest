package programmers.lv1.no72;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, ArrayList<String>> call = new HashMap<>();
        HashMap<String, ArrayList<String>> ban = new HashMap<>();

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            if (!call.containsKey(split[0])) {
                ArrayList<String> clist = new ArrayList<>();
                clist.add(split[1]);
                call.put(split[0], clist);
            } else {
                if (!call.get(split[0]).contains(split[1])) {
                    call.get(split[0]).add(split[1]);
                }
            }

            if (!ban.containsKey(split[1])) {
                ArrayList<String> blist = new ArrayList<>();
                blist.add(split[0]);
                ban.put(split[1], blist);
            } else {
                if (!ban.get(split[1]).contains(split[0])) {
                    ban.get(split[1]).add(split[0]);
                }
            }
        }

        ArrayList<String> BAN = new ArrayList<>();
        for (String s : ban.keySet()) {
            if (ban.get(s).size() >= k) {
                BAN.add(s);
            }
        }

        for (int j = 0; j < id_list.length; j++) {
            if (!call.containsKey(id_list[j])) {
                answer[j] = 0;
            } else {
                for (int l = 0; l < BAN.size(); l++) {
                    if (call.get(id_list[j]).contains(BAN.get(l))) {
                        answer[j]++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        s.solution(id_list, report, k);
    }
}