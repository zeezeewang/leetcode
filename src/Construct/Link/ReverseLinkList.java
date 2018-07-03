package Construct.Link;

public class ReverseLinkList {
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

        head = reverse(head);

        System.out.println("\n------------------------------------------------");
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    public static Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node reHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }

}

class Node {
    private int data;

    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}