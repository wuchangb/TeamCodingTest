package programmers.lv1.no70;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        int TODAY = cal(today);
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            String[] split = terms[i].split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            if ((cal(privacy[0]) + (map.get(privacy[1]) * 28)) <= TODAY) {
                list.add(i + 1);
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public int cal(String today) {
        int sum = 0;
        String[] arr = today.split("[.]");
        sum += (Integer.parseInt(arr[0])-1) * 12 * 28;
        sum += (Integer.parseInt(arr[1])-1) * 28;
        sum += Integer.parseInt(arr[2]);

        return sum;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        Solution s = new Solution();
        System.out.println(s.solution(today, terms, privacies));

    }
}