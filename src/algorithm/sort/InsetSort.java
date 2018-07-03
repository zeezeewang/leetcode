package algorithm.sort;

public class InsetSort {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 13, 22, 1, 5, 8, 2, -1};

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
        for (int a : array) {
            System.out.println(a);
        }
    }
}
