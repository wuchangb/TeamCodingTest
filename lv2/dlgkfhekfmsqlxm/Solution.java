package programmers.lv2.dlgkfhekfmsqlxm;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String s = Long.toString(numbers[i], 2);
                int zero = s.lastIndexOf("0");
                if (zero == -1) {
                    s = "10" + s.substring(1);
                    answer[i] = Long.parseLong(s, 2);
                } else {
                    s = s.substring(0, zero) + "10" + s.substring(zero + 2);
                    answer[i] = Long.parseLong(s, 2);
                }
            }
        }
        return answer;
    }
}