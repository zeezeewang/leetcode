package construct.queue;

public class QueueList implements Queue {

    private static class Node {
        private Node next;

        private String str;

        private Node(String str, Node next) {
            this.str = str;
            this.next = next;
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
        Node node = new Node(str, null);
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
        if (head == null) {
            return null;
        }

        String str = head.str;
        if (head.next != null) {
            head = head.next;
        } else {
            head = tail = null;
        }
        size--;
        return str;
    }

    @Override
    public String peek() {
        if (head == null) {
            return null;
        }
        return head.str;
    }

    public static void main(String[] args) {
        QueueList ql = new QueueList();
        System.out.println(ql.pop());

        ql.push("fsaae");
        ql.push("hfsjff");
        ql.push("ghtfdt");

        System.out.println(ql.pop());
        System.out.println(ql.pop());
        System.out.println(ql.peek());
    }

}
