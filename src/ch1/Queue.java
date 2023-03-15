package ch1;

import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> queue = new ArrayList<Integer>();

    public void enQueue(int num) {
        queue.add(num);
    }

    public int deQueue(){
        if(queue.isEmpty()){
            return 0;
        }
        return queue.remove(0);
    }

    public static void main(String[] args) {
        Queue queue1 = new Queue();
        queue1.enQueue(10);
        queue1.enQueue(20);
        queue1.enQueue(30);

        System.out.println(queue1.deQueue());
        System.out.println(queue1.deQueue());
        System.out.println(queue1.deQueue());
    }
}
