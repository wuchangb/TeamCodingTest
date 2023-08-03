package fastcampus_codingtest.second.no3;

import java.util.ArrayList;

class Solution {
    public int solution(int[] s) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i =0; i < s.length; i++) {
            if (s[i] == 4) {
                answer++;
            } else if (s[i] == 3) {
                count3++;
            } else if (s[i] == 2) {
                count2++;
                if (count2 / 2 == 1) {
                    count2 = 0;
                    answer++;
                }
            } else {
                count1++;
            }
        }

        int oneThree = Math.min(count1, count3);
        answer += oneThree;
        count1 -= oneThree;
        count3 -= oneThree;
        
        for (int i = 0; i < count1; i++) {
            list.add(1);
        }
        for (int i = 0; i < count2; i++) {
            list.add(2);
        }
        for (int i = 0; i < count3; i++) {
            list.add(3);
        }

        if (list.size() == 0) {
            return answer;
        }

        if (list.get(list.size() - 1) == 3) {
            answer += list.size();
        } else if (list.get(list.size() - 1) == 2) {
            answer += ((list.size()+1) / 4)+1;
        } else {
            answer += (list.size() / 4)+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] s = {1,2,4,3,3};
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }

}
