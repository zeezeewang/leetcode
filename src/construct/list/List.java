package construct.list;

public interface List {

    /**
     * 往链表尾部追加一个元素
     * 尾部追加一个元素 2
     * 1, 7, 3  -> 1, 7, 3, 2
     * @param number
     */
    void append(Integer number);

    /**
     * 往链表头部追加一个元素
     * 头部追加一个元素 2
     * 1, 7, 3  -> 2, 1, 7, 3
     * @param number
     */
    void prepend(Integer number);

    /**
     * 往链表的某个位置处添加一个元素
     * 往链表的1处添加一个2
     * 1, 7, 3  -> 1, 7, 2, 3
     * @param number
     */
    void insertAt(Integer number, int index);

    /**
     * Remove the first element from the list
     */
    void popFront();

    /**
     * Remove the last element from the list
     */
    void popLast();

    /**
     * Remove the element in index
     * say index is 2
     * 1 3 2 7 -> 1 3 7
     * @param index
     */
    void removeAt(int index);

    /**
     * Check if the specified number exists in the list
     * @param number
     * @return
     */
    boolean contains(Integer number);
}
