package ch2.DP;

public class DynamicProgramming {

    public int dp(int data) {
        int[] arr = new int[data + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < data + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[data];
    }
}

class RecursiveCall {
    public int recur(int data) {
        if (data <= 1) {
            return data;
        }
        return recur(data - 1) + recur(data - 1);
    }
}
