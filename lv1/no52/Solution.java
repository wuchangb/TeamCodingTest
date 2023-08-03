package programmers.lv1.no52;

import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        ArrayList<String> list = split(dartResult);
        ArrayList<Integer> scoreList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int score = 0;
            String str = list.get(i);
            if (str.charAt(1) == 48) {
                score = Integer.parseInt(list.get(i).substring(0, 2));
                if (str.charAt(2) == '*') {
                    if (scoreList.size() > 0) {
                        int preScore = scoreList.get(i - 1);
                        scoreList.remove(i - 1);
                        scoreList.add(preScore * 2);
                        scoreList.add(score * 2);
                    } else {
                        scoreList.add(score * 2);
                    }
                } else {
                    scoreList.add(score * -1);
                }

            } else {
                score = Integer.parseInt(list.get(i).substring(0, 1));
                if (str.charAt(1) == '*') {
                    if (scoreList.size() > 0) {
                        int preScore = scoreList.get(i - 1);
                        scoreList.remove(i - 1);
                        scoreList.add(preScore * 2);
                        scoreList.add(score * 2);
                    } else {
                        scoreList.add(score * 2);
                    }
                } else {
                    scoreList.add(score * -1);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < scoreList.size(); i++) {
            answer += scoreList.get(i);
        }
        return answer;
    }

    public ArrayList<String> split(String dart) {
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        str += dart.charAt(0);
        for (int i = 1; i < dart.length(); i++) {
            if (dart.charAt(i) == 48) {
                str += dart.charAt(i);
            } else if (dart.charAt(i) < 49 || dart.charAt(i) > 57) {
                str += dart.charAt(i);
            } else {
                list.add(str);
                str = ""+dart.charAt(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String dartResult = "10S2D*3T";
        Solution s = new Solution();
        s.solution(dartResult);
    }
}