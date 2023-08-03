package ch1;

import java.util.ArrayList;

public class Stack {

    ArrayList<Integer> stack = new ArrayList<>();

    public void push(int num){
        stack.add(num);
    }

    public int pop(){
        if(stack.isEmpty()){
            return 0;
        }
        return stack.remove(stack.size()-1);
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
