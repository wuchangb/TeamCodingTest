package programmers.lv1.no11;

class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int num=0;
        String str = String.valueOf(x);
        for (int i = 0; i < str.length(); i++) {
            num += str.charAt(i)-48;
        }

        if (x % num == 0) {
            answer = true;
        }
        return answer;
    }

    public static void main(String[] args) {
        int x = 124;
        int num = 0;
        String str = String.valueOf(x);
        for (int i = 0; i < str.length(); i++) {
            num += str.charAt(i)-48;
        }
        System.out.println(num);
    }
}