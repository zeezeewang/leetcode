package construct.stack;

public class CircularLinkList implements Stack {

    private static class Node {
        private String str;
        private Node next;

        Node() {
            this.str = null;
            this.next = null;
        }

        Node(String str, Node next) {
            this.str = str;
            this.next = next;
        }
    }

    private Node head;

    private int size;

    private CircularLinkList() {
        head = new Node();
        head.next = head;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(String str) {
        Node node = new Node(str, null);
        if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = node;
            node.next = head;
        }
        size++;
    }

    @Override
    public String pop() {
        if (head == null) {
            return null;
        }else{
        Node previous = null;
        Node current = head;
        while (current.next != head) {
            previous = current;
            current = current.next;
        }
        previous.next = head;
        size--;
        return current.str;
        }
    }

    @Override
    public String peek() {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            return current.str;
        }

    void print()
    {
        System.out.print("打印链表：");
        Node temp =head;
        while(temp.next!=head)
        {
            temp=temp.next;
            System.out.print(temp.str + "\t");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        CircularLinkList cl = new CircularLinkList();
        //cl.push("11");
        //cl.push("22");
        //cl.push("33");
        //cl.push("44");
        //cl.push("55");
        //cl.print();
        System.out.println(cl.pop());
        //System.out.println(cl.peek());
        //System.out.println(cl.pop());
        //System.out.println(cl.peek());



    }
}
