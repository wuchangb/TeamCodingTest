package ch2.mergeSort;

import java.util.ArrayList;

public class MergeSort {

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        //case1 - left/right 둘다 있을때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergeList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergeList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        //case2 - right 데이터가 없을때
        while (leftList.size() > leftPoint) {
            mergeList.add(leftList.get(leftPoint));
            leftPoint+=1;
        }

        //case3 - left 데이터가 없을때
        while (rightList.size() > rightPoint) {
            mergeList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergeList;
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {

        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size()/2;

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = this.mergeSplitFunc(new ArrayList<>(dataList.subList(0, medium)));
        rightArr = this.mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return this.mergeFunc(leftArr, rightArr);
    }

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            test.add((int) (Math.random() * 100));
        }

        MergeSort mergeSort = new MergeSort();
        System.out.println(mergeSort.mergeSplitFunc(test));
    }
}
