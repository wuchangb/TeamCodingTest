package programmers.lv2.n진수게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int count = 0;
        int index = 0;
        int at;
        String str = "";
        while (answer.length() < t) {
            at = (count * m) + p;
            while (str.length() < at) {
                if (n == 16) {
                    str += Integer.toHexString(index).toUpperCase();
                    index++;
                } else {
                    str += makeN(n, index);
                    index++;
                }
            }
            answer += str.charAt(at - 1);
            count++;
        }
        return answer;
    }

    public String makeN(int n, int num) {
        String str = "";
        while (num >= n) {
            str += num % n;
            num /= n;
        }
        str += num;
        StringBuffer sb = new StringBuffer(str);
        str = sb.reverse().toString();
        return str;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.makeN(2,5));
        System.out.println(sol.solution(2,4,2,1));
    }
}