package ch2.insertionSort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (list.get(j) < list.get(j - 1)) {
                    Collections.swap(list, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }

        InsertionSort insertion = new InsertionSort();
        insertion.sort(testData);
        System.out.println(testData);
    }
}
