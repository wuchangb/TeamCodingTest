package programmers.lv1.no37;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = "";
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (make2(n, arr1[i]).charAt(j) == '0' && make2(n, arr2[i]).charAt(j) == '0') {
                    answer[i] += " ";
                } else {
                    answer[i] += "#";
                }
            }

        }
        return answer;
    }

    public String make2(int count, int num) {
        String n="";
        while (num > 0) {
            n += num%2;
            num /=2;
        }

        String str = "";
        if (n.length() < count) {
            for (int i = 0; i < count - n.length(); i++) {
                str += "0";
            }
        }
        n += str;
        StringBuffer sb = new StringBuffer(n);
        n = sb.reverse().toString();
        return n;
    }

    public static void main(String[] args) {
        int n=5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        Solution s = new Solution();
//        s.solution(n, arr1, arr2);
        System.out.println(s.make2(n, 1));

//        String str = "#";
//        System.out.println(str.charAt(0)=='#');
    }
}