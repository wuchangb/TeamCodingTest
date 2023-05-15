package programmers.lv2.k진수에서소수찾기;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = makeN(n, k);
        String tmp = "";
        StringTokenizer st = new StringTokenizer(str, "0");
        List<String> arr = new ArrayList<>();

        while (st.hasMoreTokens()) {
            arr.add(st.nextToken());
        }
        for (int i = 0; i < arr.size(); i++) {
            if (count(Long.parseLong(arr.get(i)))) {
                answer++;
            }
        }
        return answer;
    }

    public String makeN(int n, int k) {
        String str = "";
        while (n / k > 0) {
            str += n % k;
            n /= k;
        }
        str += n;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }

    public boolean count(long n) {
        int count = 0;

        if (n == 1) {
            return false;
        }
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count > 1) return false;
        else return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 437674;
        int k = 3;
        System.out.println(sol.solution(n,k));
    }
}