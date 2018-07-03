package Construct.queue;

import java.util.ArrayList;
import java.util.List;

public class ListQueue implements Queue {

    private List<String> list = new ArrayList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void push(String str) { list.add(str); }

    @Override
    public String pop() {
        return list.remove(0);
    }

    @Override
    public String peek() {
        return list.get(0);
    }

    public void display() {
        System.out.println("----------------------------------------");
        System.out.println(list);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        final ListQueue myQueue = new ListQueue();

        for (int i = 0; i < 15; i++) {
            myQueue.push(String.valueOf(i));
        }

        myQueue.display();  //  0 1 .... 14

        myQueue.pop();
        myQueue.display();  //  1 2 ... 14

        myQueue.pop();
        myQueue.display();  //  2 ... 14, 1 3 4 ... 14

    }

}
