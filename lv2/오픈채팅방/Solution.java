package programmers.lv2.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> entrance = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            if (record[i].charAt(0) == 'E') {
                map.put(arr[1], arr[2]);
                entrance.put(arr[1], 0);
                list.add(arr[1]);
            } else if (record[i].charAt(0) == 'C') {
                map.put(arr[1], arr[2]);
            } else {
                list.add(arr[1]);
            }
        }

        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            if (entrance.get(list.get(i)) == 0) {
                entrance.put(list.get(i), 1);
                answer[i] = map.get(list.get(i)) + "님이 들어왔습니다.";
            } else {
                entrance.put(list.get(i), 0);
                answer[i] = map.get(list.get(i)) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}