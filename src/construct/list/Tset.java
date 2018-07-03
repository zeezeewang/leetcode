package construct.list;

import java.util.Stack;

public class Tset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stack<Integer> stack = new Stack<>();
        for (Integer i : arr) {
            stack.push(i);
        }

        {
            while(!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }


//        final int size  = stack.size();
//        for (int j = 0; j < size; j++) {
//            System.out.println(j + ", " + stack.size() + ", " + stack.pop());
//        }
    }
}
