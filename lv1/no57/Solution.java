package programmers.lv1.no57;



class Solution {
    public String solution(String X, String Y) {
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        StringBuilder sb= new StringBuilder();
//        for (String x : X.split("")) {
//            arrX[Integer.parseInt(x)]++;
//        }
//        for (String x : X.split("")) {
//            arrX[Integer.parseInt(x)]++;
//        }
        for (int i = 0; i < X.length(); i++) {
            arrX[X.charAt(i)-'0']++;
        }
        for (int i = 0; i < Y.length(); i++) {
            arrY[Y.charAt(i)-'0']++;
        }


        for (int i = 9; i >= 0; i--) {
            while (arrX[i] >= 1 && arrY[i] >= 1) {
                sb.append(i);
                arrX[i]--;
                arrY[i]--;

            }
        }
        if (sb.length() == 0) {
            return "-1";
        } else if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String X = "12321";
        String Y = "42531";
        s.solution(X, Y);
    }
}