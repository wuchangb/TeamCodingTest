package fastcampus_codingtest.third.no1;

import java.util.ArrayList;

public class Solution {
    public String[] solution(String s) {

        String str = "";
        String same = "";
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (same.length() >= 1) {
                if (same.charAt(same.length() - 1) == s.charAt(i)) {
                    same += s.charAt(i);
                } else {
                    same = "";
                    str += s.charAt(i);
                }
            } else {
                if (str.length() == 0) {
                    str += s.charAt(i);
                } else {
                    if (str.charAt(str.length() - 1) == s.charAt(i)) {
                        str = str.substring(0, str.length() - 1);
                        if (str.equals("")) {
                            if (list.isEmpty()) {
                                list.add(str);
                            } else {
                                if (!list.get(list.size() - 1).equals("")) {
                                    list.add(str);
                                }
                            }
                        } else {
                            list.add(str);
                        }
                        str = "";
                        same += s.charAt(i);
                    } else {
                        str += s.charAt(i);
                    }
                }
            }
        }

        if (same.length() > 0) list.add("");
        if (str.length() > 0) list.add(str);

        for (int i = 1; i < list.size()-1; i++) {
            if (list.get(i).equals("")) {
                list.remove(i);
            }
        }

        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        String s = "abbccd";
        Solution sol = new Solution();
        String[] arr = sol.solution(s);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
