package Construct.Link;

public class ReverseMethod2 {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        Node h = head;
        while (h != null) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }

        head = Reverse2(head);

        System.out.println("\n------------------------");
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }


    }

    public static Node Reverse2(Node head) {
        if (head == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.getNext();
        Node temp;
        while (cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;

        }
        head.setNext(null);
        return pre;
    }
}

class Node2 {
    private int date;

    private Node next;

    public Node2(int data) {
        this.date = data;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}