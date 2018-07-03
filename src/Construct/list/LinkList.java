package Construct.list;

public class LinkList implements List {

    private static class Node {
        private Node next;

        private Integer number;

        private Node(Node next, Integer number) {
            this.next = next;
            this.number = number;
        }
    }

    private Node head;

    private Node tail;

    @Override
    public void append(Integer number) {
        Node node = new Node(null, number);
        if (tail != null) {
            tail.next = node;
            tail = node;
        } else {
            head = tail = node;
        }
    }

    @Override
    public void prepend(Integer number) {
        Node node = new Node(null, number);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }

    }

    @Override
    public void insertAt(Integer number, int index) {
        Node node = new Node(null, number);
        if (index == 1 || head == null) {
            node.next = head;
            head = node;
            return;
        }

        Node current = head;
        while (current.next != null && index > 1) {
            current = current.next;
            index--;
        }

        node.next = current.next;
        current.next  = node;

    }

    @Override
    public void popFront() {
        if (head == null) {
            System.out.println("此链为空链");
            return;
        }
        if (head.next != null) {
            head = head.next;
        } else {
            head = tail = null;
        }

    }

    @Override
    public void popLast() {
        // bug here...
        if (tail.next!= null) {
            tail = tail.next;
        } else {
            head = tail = null;
        }
    }

    @Override
    public void removeAt(int index) {
        if (index < 1) {
            System.out.println("给定的位置不合理");
            return;
        }

        Node previous = null;
        Node current = head;
        int count = 1;
        while (current != null) {
            if (count == index) {
                if (previous == null) {
                    head = current.next;
                } else  {
                    previous.next = current.next;
                }
                break;
            }
            previous = current;
            current = current.next;
            count++;
        }
    }


    @Override
    public boolean contains(Integer number) {
        Node current = head;
        while (current != null) {
            if (current.number != null && current.number.equals(number)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void display() {
        Node current = head;
        System.out.println("----------------------------------------");
        while (current != null) {
            System.out.print(current.number + " ");
            current = current.next;
        }
        System.out.println();
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        LinkList li = new LinkList();
        li.append(12);
        li.append(22);
        li.append(32);
        li.append(42);
        li.display();


        //System.out.println(li.contains(12));
        li.removeAt(2);
        //System.out.println(li.contains(22));
        //li.insertAt(52,3);
        li.display();

    }
}

