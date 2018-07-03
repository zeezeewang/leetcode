package Algorithm.Sort;

public class BinaryInsertSort {

    private void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int min = 0;
            int max = i - 1;
            int mid = 0;
            while (min <= max) {
                mid = (min + max) / 2;
                if (temp > a[mid]) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            for (int j = i - 1; j >= min; j--) {
              a[j + 1] = a[j];
            }
            if (min != i) {
                a[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 13, 22, 1, 5, 8, 2};
        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
        binaryInsertSort.sort(array);
        for (int a : array) {
            System.out.println(a);

        }

    }
}
