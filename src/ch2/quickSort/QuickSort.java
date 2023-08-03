package ch2.quickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public ArrayList<Integer> sort(ArrayList<Integer> list) {

        if (list.size() <= 1) {
            return list;
        }
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        int pivot = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= pivot) {
                rightArr.add(list.get(i));
            } else {
                leftArr.add(list.get(i));
            }
        }

        ArrayList<Integer> mergeArr = new ArrayList<>();
        mergeArr.addAll(sort(leftArr));
        mergeArr.add(pivot);
        mergeArr.addAll(sort(rightArr));

        return mergeArr;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int)(Math.random() * 100));
        }
//        System.out.println(list);
        System.out.println(quickSort.sort(list));
    }
}
