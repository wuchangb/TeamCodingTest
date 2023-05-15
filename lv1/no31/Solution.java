package programmers.lv1.no31;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = "";
        while (n >= 3) {
            num += n%3;
            n /= 3;
        }
        num += n;
        answer = Integer.parseInt(num, 3);
        return answer;
    }

    public static void main(String[] args) {
        int n = 60;
        int answer = 0;
        String num = "";
        while (n >= 3) {
            num += n%3;
            n /= 3;
        }
        num += n;
        System.out.println(num);

        String i = "0";
        System.out.println(i.charAt(0)*1);
    }
}