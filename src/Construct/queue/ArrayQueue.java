package Construct.queue;


public class ArrayQueue implements Queue {

    private String[] arr;

    private int front;

    private int end;


    public ArrayQueue(int capacity) {
        this.arr = new String[capacity];
        front = 0;
        end = -1;
    }

    @Override
    public int size() {
        return end - front;
    }

    @Override
    public void push(String str) {
        if (end == arr.length) {
            end = -1;
        }
        arr[++end] = str;
    }

    @Override
    public String pop() {
        String str = arr[front++];
        if (front == arr.length) {
            front = 0;
        }
        return str;
    }

    @Override
    public String peek() {
        return arr[front];
    }

    public static void main(String[] args) {
        Queue myQueue = new ArrayQueue(4);

        myQueue.push("33");
        System.out.println(myQueue.size());

        myQueue.push("21");
        System.out.println(myQueue.size());

        myQueue.push("89");
        System.out.println(myQueue.size());

        myQueue.push("77");
        System.out.println(myQueue.size());

        System.out.println(myQueue.peek());
    }
}
