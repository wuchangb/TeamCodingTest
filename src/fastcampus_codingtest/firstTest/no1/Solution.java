package fastcampus_codingtest.firstTest.no1;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] cards) {
        int answer = 0;

        int[] arr = new int[14];
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == 0) {
                arr[0]++;
                count++;
            } else if (!list.contains(cards[i])) {
                list.add(cards[i]);
            } else {
                arr[cards[i]]++;
                count++;
            }

            if (count >= 3) {
                if (arr[0] == 5) {
                    list = new ArrayList<>();
                    count = 0;
                    answer++;
                    arr = new int[14];
                } else if (arr[0] == 4) {
                    if (list.size() >= 1) {
                        list = new ArrayList<>();
                        count = 0;
                        answer++;
                        arr = new int[14];
                    }
                } else if (arr[0] == 3) {
                    if (list.size() > 1 || (list.size()==1 && arr[list.get(0)]>=2)) {
                        list = new ArrayList<>();
                        count = 0;
                        answer++;
                        arr = new int[14];
                    }
                } else if (arr[0] == 2) {
                    int num1 = 0;
                    int num2 = 0;
                    int num3 = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if (arr[list.get(j)] == 1) {
                            num1++;
                        } else if (arr[list.get(j)] == 2) {
                            num2++;
                        } else if (arr[list.get(j)] == 3) {
                            num3++;
                        }
                    }
                    if (num3 >= 1 || (num1 >= 1 && num2 >= 1)) {
                        list = new ArrayList<>();
                        count = 0;
                        answer++;
                        arr = new int[14];
                    }
                } else if (arr[0] == 1) {
                    int num1 = 0;
                    int num2 = 0;
                    int num3 = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if (arr[list.get(j)] == 2) {
                            num2++;
                        } else if (arr[list.get(j)] == 1) {
                            num1++;
                        } else if (arr[list.get(j)] == 3) {
                            num3++;
                        }
                    }
                    if (num2 >= 2 || (num1 >= 1 && num3 >= 1)) {
                        list = new ArrayList<>();
                        count = 0;
                        answer++;
                        arr = new int[14];
                    }
                } else {
                    int num2 = 0;
                    int num3 = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if (arr[list.get(j)] == 2) {
                            num2++;
                        } else if (arr[list.get(j)] == 3) {
                            num3++;
                        }
                    }
                    if (num2 >= 1 && num3 >= 1) {
                        list = new ArrayList<>();
                        count = 0;
                        answer++;
                        arr = new int[14];
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] cards = {0, 0, 1, 0};
        System.out.println(s.solution(cards));
    }
}
