package programmers.lv1.no62;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        List<String> card1List = new ArrayList<>();
        List<String> card2List = new ArrayList<>();

        for (int i = 0; i < cards1.length; i++) {
            card1List.add(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            card2List.add(cards2[i]);
        }

        for (int i = 0; i < goal.length; i++) {
            if (card1List.size() == 0) {
                if (goal[i].equals(card2List.get(0))) {
                    card2List.remove(0);
                } else {
                    answer = "No";
                    break;
                }
            } else if (card2List.size() == 0) {
                if (goal[i].equals(card1List.get(0))) {
                    card1List.remove(0);
                } else {
                    answer = "No";
                    break;
                }
            } else if (goal[i].equals(card1List.get(0))) {
                card1List.remove(0);
            } else if (goal[i].equals(card2List.get(0))) {
                card2List.remove(0);
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        s.solution(cards1, cards2, goal);
    }
}