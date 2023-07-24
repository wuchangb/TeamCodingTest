package ch2.quickSort;

import java.util.ArrayList;

public class QuickSortV2 {

    public void quickSort(int[] arr, int start, int end) {
        int part = partition(arr, start, end);

        if (start < part-1) {
            quickSort(arr, start, part-1);
        }
        if (part < end) {
            quickSort(arr, part, end);
        }
    }

    public int partition(int[] arr, int start, int end) {
        int pivot = (start + end) / 2;

        while (start <= end) {
            while (arr[start] < arr[pivot]) start++;
            while (arr[end] > arr[pivot]) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    public void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 6, 2, 5, 4, 7, 4, 8, 13, 76, 45, 6, 3, 7, 3, 7, 9};
        QuickSortV2 quickSortV2 = new QuickSortV2();
        quickSortV2.quickSort(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
