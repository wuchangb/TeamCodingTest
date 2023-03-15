package ch2.quickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public ArrayList<Integer> sort(ArrayList<Integer> list) {

        if (list.size() <= 1) {
            return list;
        }

        int pivot = list.get(0);
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > pivot) {
                rightArr.add(list.get(i));
            } else {
                leftArr.add(list.get(i));
            }
        }

        ArrayList<Integer> mergeArr = new ArrayList<>();
        mergeArr.addAll(this.sort(leftArr));
        mergeArr.addAll(Arrays.asList(pivot));
        mergeArr.addAll(this.sort(rightArr));

        return mergeArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            test.add((int) (Math.random() * 100));
        }

        QuickSort sort = new QuickSort();
        System.out.println(sort.sort(test));
    }
}
