package programmers.lv2.jadencase;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) < 65) {
                answer += arr[i].charAt(0) + arr[i].substring(1).toLowerCase() + " ";
            } else {
                answer += arr[i].substring(0,1).toUpperCase() + arr[i].substring(1).toLowerCase() + " ";
            }
        }
        answer.substring(0, answer.length());
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "3people unFollowed me";
        System.out.println(s.solution(str));
    }
}