package construct.Link;

public interface Link {

    void enqueue(String str);

    String dequeue();

    int getSize();

    boolean isEmpty();
}
