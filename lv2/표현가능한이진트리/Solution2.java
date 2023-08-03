package programmers.lv2.표현가능한이진트리;

public class Solution2 {

    static boolean arr[];
    static int result;

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String str = Long.toBinaryString(numbers[i]);
            int strLen = str.length();
            int len = 0;
            int depth = 1;
            while ((len = (int)Math.pow(2, depth) - 1) < strLen) {
                depth++;
            }
            int idx = len - strLen;
            arr = new boolean[len];
            for (int j = 0; j < strLen; j++) {
                arr[idx++] = str.charAt(j) == '1';
            }
            result = 1;
            dfs(arr, 0, len - 1);
            answer[i] = result;
        }
        return answer;
    }

    static void dfs(boolean[] arr, int start, int end) {
        if (start==end) return;

        int mid = (start+end)/2;
        int left = (start + mid-1)/2;
        int right = (mid+1 + end)/2;

        if (!arr[mid] && (arr[left] || arr[right])) {
            result = 0;
        }

        dfs(arr, start, mid-1);
        dfs(arr, mid + 1, end);
    }
}
