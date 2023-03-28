package ch2.selectionSort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort2 {
    public ArrayList<Integer> sort(ArrayList<Integer> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;

            for (int j = i+1; j < list.size(); j++) {
                if (list.get(min) > list.get(j)) {
                    min = j;
                }
            }
            Collections.swap(list, min, i);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 100));
        }
        SelectionSort2 s = new SelectionSort2();
        System.out.println(s.sort(list));
    }
}
