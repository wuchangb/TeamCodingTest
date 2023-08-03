package programmers.lv2.표현가능한이진트리;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String s = makeBinary(numbers[i]);
            if (check(s)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    static boolean check(String s) {
        if (s.equals("1")) return true;
        int len = s.length();
        if (len <= 3) {
                for (int i = 0; i < 3 - len; i++) {
                    s += 0;
                }
            String binary = swap(s);
            for (int i = 1; i < 3; i += 2) {
                if (binary.charAt(i) == '0') return false;
            }
        } else if (len > 3 && len <= 7) {
                for (int i = 0; i < 7 - len; i++) {
                    s += 0;
                }
            String binary = swap(s);
            for (int i = 1; i < 7; i += 2) {
                if (binary.charAt(i) == '0') return false;
            }
        } else if (len > 7 && len <= 15) {
                for (int i = 0; i < 15 - len; i++) {
                    s += 0;
                }
            String binary = swap(s);
            for (int i = 1; i < 15; i += 2) {
                if (binary.charAt(i) == '0') return false;
            }
        } else if (len > 15 && len <= 31) {
                for (int i = 0; i < 31 - len; i++) {
                    s += 0;
                }
            String binary = swap(s);
            for (int i = 1; i < 31; i += 2) {
                if (binary.charAt(i) == '0') return false;
            }
        } else {
                for (int i = 0; i < 63 - len; i++) {
                    s += 0;
                }
            String binary = swap(s);
            for (int i = 1; i < 63; i += 2) {
                if (binary.charAt(i) == '0') return false;
            }
        }
        return true;
    }

    static String makeBinary(long num) {
        String str = "";

        while (num > 1) {
            str += num % 2;
            num /= 2;
        }
        str += 1;
        return str;
    }

    static String swap(String str) {
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }
}