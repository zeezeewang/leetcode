package Algorithm.Sort;

public class MergeSort {

    public void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    private void merge(int[] a, int left, int mid, int right) {
        int[] tmpArray = new int[a.length];
        int rightStart = mid + 1;
        int temp = left;
        int third = left;
        while (left <= mid && rightStart <= right) {
            if (a[left] <= a[rightStart]) {
                tmpArray[third++] = a[left++];
            } else {
                tmpArray[third++] = a[rightStart++];
            }
        }
        while (left <= mid) {
            tmpArray[third++] = a[left++];
        }
        while (rightStart <= right) {
            tmpArray[third++] = a[rightStart++];
        }
        while (temp <= right) {
            a[temp] = tmpArray[temp++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {21, 54, 26, 64, 73, 65, 24, 62, 17, 95};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
