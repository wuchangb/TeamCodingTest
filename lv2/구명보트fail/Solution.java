package programmers.lv2.구명보트fail;


import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int min = 0;
        Arrays.sort(people);

        for (int i = people.length-1; i >= min; i--) {
            if (people[i] + people[min] <= limit) {
                min++;
            }
            answer++;
        }
        return answer;
    }
}