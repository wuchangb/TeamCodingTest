package programmers.lv1.no61;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10, right = 12; // 왼손과 오른손의 초기 위치
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) { // 왼쪽 열의 숫자인 경우
                answer.append("L");
                left = number;
            } else if (number == 3 || number == 6 || number == 9) { // 오른쪽 열의 숫자인 경우
                answer.append("R");
                right = number;
            } else { // 가운데 열의 숫자인 경우
                int leftDistance = getDistance(left, number);
                int rightDistance = getDistance(right, number);
                if (leftDistance < rightDistance || (leftDistance == rightDistance && hand.equals("left"))) {
                    answer.append("L");
                    left = number;
                } else {
                    answer.append("R");
                    right = number;
                }
            }
        }
        return answer.toString();
    }

    private int getDistance(int position, int target) {
        position = (position == 0) ? 11 : position;
        target = (target == 0) ? 11 : target;
        int x1 = (position - 1) / 3;
        int y1 = (position - 1) % 3;
        int x2 = (target - 1) / 3;
        int y2 = (target - 1) % 3;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}