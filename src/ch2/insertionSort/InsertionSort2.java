package ch2.insertionSort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort2 {

    public ArrayList<Integer> sort(ArrayList<Integer> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (list.get(j) < list.get(j-1)) {
                    Collections.swap(list, j-1, j);
                } else {
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 100));
        }

        InsertionSort2 s = new InsertionSort2();
        System.out.println(s.sort(list));
    }
}
