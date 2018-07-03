package algorithm.sort;

public class QuickSort {

   public void quick(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = getMid(a, low, high);
            quickSort(a, 0, mid - 1);
            quickSort(a, mid + 1, high);
        }
    }

    private int getMid(int[] a, int low, int high) {
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = {21, 345, 15, 63, 35, 24, 64, 26, 75, 43, 98};
        quickSort.quick(a);
        for (int arr : a) {
            System.out.println(arr);
        }
    }
}
