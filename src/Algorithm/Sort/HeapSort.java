package Algorithm.Sort;

public class HeapSort {

   public static void main(String[] args) {
        int[] array = {39, 44, 1, 0, 8, 66, 23, 67, 9, 15, 100, 70, 22, 3, 6, 54};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private void heapSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        buildMaxheap(a);
        for (int i = a.length - 1; i >= 1; i--) {
            exchangeElements(a, 0, i);
            maxHeap(a,i,0);
        }
    }

    private void buildMaxheap(int[] a) {
        int half = (a.length - 1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(a, a.length, i);
        }
    }

    private void maxHeap(int[] a, int length, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < length && a[left] > a[i]) {
            largest = left;
        }
        if (right < length && a[right] > a[largest]) {
            largest = right;
        }
        if (i != largest) {
            exchangeElements(a, i, largest);
            maxHeap(a, length, largest);
        }
    }

    private void exchangeElements(int[] a, int i, int largest) {
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
    }
}


