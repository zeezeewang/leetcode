package construct.queue;

public interface Queue {

    int size();

    void push(String str);

    String pop();

    String peek();
}
