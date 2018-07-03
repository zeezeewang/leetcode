package construct.zhenze.learning;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        final int[] arr = {8, 2, 9, 1, 3};
        Arrays.sort(arr);
        /*for (int elem : arr) {
            System.out.println(elem);

        }*/
        int sum = 10;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum == arr[i] + arr[j]) {
                    System.out.println(arr[i] + "..." + arr[j]);

                }
            }
        }
    }
}
