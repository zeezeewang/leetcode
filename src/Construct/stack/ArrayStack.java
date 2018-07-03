package Construct.stack;

public class ArrayStack implements Stack {

    private String[] arr;

    private int top;

    public ArrayStack(int capacity) {
        this.arr = new String[capacity];
        top = -1;
    }


    @Override
    public int size() {
        return top;
    }

    @Override
    public void push(String str) {
        arr[++top] = str;

    }

    @Override
    public String pop() {
        return arr[top--];
    }

    @Override
    public String peek() {
        return arr[top];
    }

    public static void main(String[] args) {

        ArrayStack as = new ArrayStack(10);

        as.push("11");
        as.push("22");
        as.push("33");
        as.push("44");
        as.push("55");

        System.out.println(as.pop());

        System.out.println(as.peek());

        System.out.println(as.size());
    }
}
