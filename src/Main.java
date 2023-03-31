import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
                queue.add(i);
        }

        while(queue.size()>1){
            queue.poll();
            int temp = queue.poll();
            queue.add(temp);
        }

        System.out.println(queue.poll());


    }

}