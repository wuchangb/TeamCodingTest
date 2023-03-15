package ch2.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class GreedyAlgorithm {
    public void coinFunc(int price, ArrayList<Integer> coinList) {
        int totalCount=0;
        int count=0;
        ArrayList<Integer> detail = new ArrayList<>();

        for (int i = 0; i < coinList.size(); i++) {
            count = price / coinList.get(i);
            totalCount += count;
            price -= count * coinList.get(i);
            detail.add(count);
            System.out.println(coinList.get(i)+" 원의 갯수 : "+ count + "개");
        }

        System.out.println("총 동전갯수: "+ totalCount);
    }


    public static void main(String[] args) {
        GreedyAlgorithm ga = new GreedyAlgorithm();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(500, 100, 50, 1));
        ga.coinFunc(4721, list);
    }
}
