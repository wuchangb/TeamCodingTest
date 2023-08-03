package programmers.lv1.no32;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split("");
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) {
                count=0;
                answer += arr[i];
            } else if (count%2==0) {
                answer += arr[i].toUpperCase();
                count++;
            } else {
                answer += arr[i].toLowerCase();
                count++;
            }
        }
        return answer;
    }
}