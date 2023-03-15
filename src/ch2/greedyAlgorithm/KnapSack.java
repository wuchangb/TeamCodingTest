package ch2.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class KnapSack {
    public void knapsackFunc(int[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]/o2[0] - o1[1]/o1[0];
            }
        });

        for (int i = 0; i < objectList.length; i++) {
            if (capacity - objectList[i][0] > 0) {
                capacity -= objectList[i][0];
                totalValue += objectList[i][1];
                System.out.println("무게: " + objectList[i][0] + ", 가치: "+objectList[i][1]);
            } else {
                fraction = capacity / (double) objectList[i][0];
                totalValue += objectList[i][1] * fraction;
                System.out.println("무게: " + objectList[i][0] + ", 가치: "+objectList[i][1]+", 비율: "+fraction);
                break;
            }
        }

        System.out.println("총 담을 수 있는 가치 : " + totalValue);
    }

    public static void main(String[] args) {

        int[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        KnapSack knapSack = new KnapSack();
        knapSack.knapsackFunc(objectList, 30.0);
    }


}
