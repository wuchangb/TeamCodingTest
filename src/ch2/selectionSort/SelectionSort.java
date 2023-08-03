package ch2.selectionSort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        int lowest;
        for(int i=0; i<list.size()-1; i++){
            lowest = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(lowest) > list.get(j)) {
                    lowest = j;
                }
            }
            Collections.swap(list, lowest, i);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> random = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            random.add((int) (Math.random() * 100));
        }

        SelectionSort selection = new SelectionSort();
        selection.sort(random);
        System.out.println(random);
    }
}
