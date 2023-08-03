package programmers.lv2.뉴스클러스터링;

import java.util.ArrayList;


class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = "";
            if ((str1.charAt(i) >= 65 && str1.charAt(i) <= 90) || (str1.charAt(i) >= 97 && str1.charAt(i) <= 122)) {
                tmp += str1.charAt(i);
                if ((str1.charAt(i + 1) >= 65 && str1.charAt(i + 1) <= 90) || (str1.charAt(i + 1) >= 97 && str1.charAt(i + 1) <= 122)) {
                    tmp += str1.charAt(i + 1);
                    list1.add(tmp.toLowerCase());
                }
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = "";
            if ((str2.charAt(i) >= 65 && str2.charAt(i) <= 90) || (str2.charAt(i) >= 97 && str2.charAt(i) <= 122)) {
                tmp += str2.charAt(i);
                if ((str2.charAt(i + 1) >= 65 && str2.charAt(i + 1) <= 90) || (str2.charAt(i + 1) >= 97 && str2.charAt(i + 1) <= 122)) {
                    tmp += str2.charAt(i + 1);
                    list2.add(tmp.toLowerCase());
                }
            }
        }

        if (list1.size()==0 && list2.size()==0) {
            return 65536;
        }
        int U = makeU(list1, list2);
        int N = makeN(list1, list2);
        double answer = (double) N / U;
        return (int)(answer*65536);
    }

    public int makeU(ArrayList<String> listA, ArrayList<String> listB) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>(listA);
        ArrayList<String> list2 = new ArrayList<>(listB);
        while (list1.size() > 0) {
            if (list2.contains(list1.get(0))) {
                list.add(list1.get(0));
                list2.remove(list1.get(0));
                list1.remove(0);
            } else {
                list.add(list1.get(0));
                list1.remove(0);
            }
        }
        while (list2.size() > 0) {
            list.add(list2.get(0));
            list2.remove(0);
        }
        return list.size();
    }

    public int makeN(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> list = new ArrayList<>();

        while (list1.size() > 0) {
            if (list2.contains(list1.get(0))) {
                list.add(list1.get(0));
                list2.remove(list1.get(0));
            }
            list1.remove(0);
        }
        return list.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str1 = "abab";
        String str2 = "baba";

        s.solution(str1, str2);
    }
}