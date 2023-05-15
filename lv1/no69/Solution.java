package programmers.lv1.no69;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int tmp = 0;
            int min = 0;

            for (int j = 0; j < targets[i].length(); j++) {
                for (int k = 0; k < keymap.length; k++) {
                    if (!keymap[k].contains(targets[i].charAt(j) + "")) {
                        tmp = -1;
                    } else {
                        tmp = keymap[k].indexOf(targets[i].charAt(j));
                        if (tmp >= 0 && tmp < min) {
                            min = tmp;
                        }
                    }
                }
            }

            answer[i] += min;
        }
        return answer;
    }
}