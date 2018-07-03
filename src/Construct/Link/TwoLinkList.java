package Construct.Link;

import java.util.*;

public class TwoLinkList {

    private static class Node {

        private Node next;

        private String value;

        private Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;

    private Node tail;

    private int size;

    private void append(String value) {
        Node node = new Node(value, null);
        if (tail != null) {
            tail.next = node;
            tail = node;
        } else {
            head = tail = node;
        }
        size++;
    }

    private void display() {
        Node curr = head;
        System.out.println("---------------------------------");
        while (curr != null) {
            System.out.print(curr.value + "  ");
            curr = curr.next;
        }
        System.out.println();
        System.out.println("---------------------------------");
    }

    //private List<TwoLinkList> separateIntoNth(int n) {

    /*final TwoLinkList l1 = new TwoLinkList();
    final TwoLinkList l2 = new TwoLinkList();

    Node curr = head;
    int index = 1;
    while (curr != null) {
        if (index % 2 == 0) {
            l1.append(curr.value);
        }else {
            l2.append(curr.value);
        }
        curr = curr.next;
        index++;
    }

    final List<TwoLinkList> result = new ArrayList<>();
    result.add(l1);
    result.add(l2);
    return result;*/
    private HashMap<Integer, TwoLinkList> separateIntoNth(TwoLinkList ws, int n) {
        final HashMap<Integer, TwoLinkList> hs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hs.put(i, new TwoLinkList());
        }
        Node curr = ws.head;
        for (int j = 0; j < ws.size; j++) {
            int m = j % n;
            TwoLinkList twoLinkList = hs.get(m);
            twoLinkList.append(curr.value);
            curr = curr.next;
        }

        return hs;
    }


    public int size() {
        return size;
    }

    public static void main(String[] args) {
        final TwoLinkList li = new TwoLinkList();
        for (int i = 0; i < 100; i++) {
            li.append(String.valueOf(i));
        }
        li.display();

        final HashMap<Integer, TwoLinkList> lists = li.separateIntoNth(li, 5);
        for (Map.Entry<Integer, TwoLinkList> en : lists.entrySet()) {
            System.out.println(en.getKey() + "=");
            en.getValue().display();
        }
    }
}