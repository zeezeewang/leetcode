package list;

import java.util.Collection;

import java.util.ArrayList;

import java.util.Iterator;


class TestCollection {
    public static void main(String[] args){
        Collection c = new ArrayList();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");

        Iterator it = c.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
