package construct.stack;

public class LinkStack implements Stack {

    private static class Node {

        private Node next;

        private String str;

        private Node(Node next, String str) {
            this.next = next;
            this.str = str;
        }

    }

    private Node head;

    private Node tail;

    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(String str) {
        Node node = new Node(null, str);
        if (tail != null) {
            tail.next = node;
            tail = node;
        } else {
            head = tail = node;
        }
        size++;

    }

    @Override
    public String pop() {
        if (tail == null) {
            return null;
        }

        final String str = tail.str;

        Node previous = null;
        Node current = head;
        int count = 1;
        while (count != size) {
            previous = current;
            current = current.next;
            count++;
        }

        previous.next = null;
        tail = previous;
        size--;
        return str;
    }

    @Override
    public String peek() {
        if (tail == null) {
            return null;
        }
        return tail.str;
    }

    private void display() {
        Node current = head;
        System.out.println("----------------------------------------");
        while (current != null) {
            System.out.print(current.str + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("----------------------------------------");

    }

    public static void main(String[] args) {

        LinkStack ls = new LinkStack();

        ls.push("11");
        ls.push("22");
        ls.push("33");
        ls.push("44");
        ls.push("55");

        //ls.display();

        //System.out.println(ls.size());

        System.out.println(ls.pop());

        ls.display();

        //System.out.println(ls.size());

        //System.out.println(ls.peek());


    }
}
