package ch1.LinkedList;

public class LinkedList2<Integer> {

    public Node head = null;

    public class Node {
        int data;
        Node next = null;
        public Node(int data) {
            this.data = data;
        }
    }

    public int addNode(int add) {
        if (head == null) {
            this.head = new Node(add);
        } else {
            Node node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(add);
        }
        return 0;
    }


}
