package construct.stack;

import java.util.ArrayList;
import java.util.List;

public class ListStack implements Stack{

    private List<String> list;

    private int top;

    public ListStack(){
        this.list = new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void push(String str) {
        list.add(str);
    }

    @Override
    public String pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public String peek() {
        return list.get(list.size() - 1);
    }

    public static void main(String[] args){

        ListStack ls = new ListStack();

        ls.push("11");
        ls.push("22");
        ls.push("33");
        ls.push("44");
        ls.push("55");

        System.out.println(ls.pop());

        System.out.println(ls.peek());

        System.out.println(ls.size());
    }
}
