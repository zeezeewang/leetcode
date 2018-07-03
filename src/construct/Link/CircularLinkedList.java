package construct.Link;

public class CircularLinkedList implements Link {

    private static class Node {

        private String value;
        private Node next;

        /*Node() {
            this.value = null;
            this.next = null;
        }*/

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    private int size;

    /*private CircularLinkedList() {
        head = null;
    }*/

    @Override
    public void enqueue(String value) {
        final Node node = new Node(value);
        if (head == null) {
            head = node;
            head.next = head;
        } else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = node;
            node.next = head;
        }
        size++;
    }

    @Override
    public String dequeue() {
        Node previous = null;
        Node current = head;
        //for(int j = 0;  j < 15;  j++)
        for (int i = 0; i < 3; i++) {
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        size--;
        return current.value;
    }

    private static void log(String message) {
        System.out.println(message);
    }

    private void joeRing() {
        if (head == null) {
            log("Circular list is empty..");
            return;
        }

        Node prev = null;
        Node curr = head;
        while (curr.next != curr) {
            for (int i = 0; i < 2; i++) {
                prev = curr;
                curr = curr.next;
            }

            log("Kick out " + curr.value);

            prev.next = curr.next;
            curr = curr.next;
            size--;
        }

        log(curr.value + " wins");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void print() {
        Node curr = head;
        for (int i = 0; i < size; i++) {
            log(String.format("%s(%s)\t", curr.value, curr.next.value));
            curr = curr.next;
        }
        log("");
    }

    public static void main(String[] args) {
        final String[] names = {
                "Alice", "Bob", "Cindy", "Doug", "Ed",
                "Fred", "Gene", "Hope", "Irene", "Jack",
                "Kim", "Lance", "Mike", "Nancy", "Ollie"
        };

        final CircularLinkedList list = new CircularLinkedList();
        for (final String name : names) {
            list.enqueue(name);
        }

        list.print();

        list.joeRing();

//        while (list.getSize() > 1) {
//            list.print();
//            System.out.println("\n\t" + list.dequeue() + "退出");
//        }

    }
}
