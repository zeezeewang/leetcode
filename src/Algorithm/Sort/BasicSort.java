package Algorithm.Sort;

import java.util.ArrayList;
import java.util.List;

public class BasicSort {

    //这是改进版本
   public void sort(int[] array) {
        int max = 0;
        for (int element : array) {
            if (max < element) {
                max = element;
            }
        }

        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }

        List<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queue.add(new ArrayList<>());
        }

        for (int i = 0; i < times; i++) {
            for (int element : array) {
                int x = element % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> subQueue = queue.get(x);
                subQueue.add(element);
            }

            int count = 0;
            for (int j = 0; j < 10; j++) {
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> subQueue = queue.get(j);
                    array[count] = subQueue.get(0);
                    subQueue.remove(0);
                    count++;

                }
            }
        }

    }
    /*public  void sort(int[] array){
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int times = 0;
        while (max > 0) {
            max = max / 10;
            times++;
        }
        List<ArrayList> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList q = new ArrayList<>();
            queue.add(q);
        }
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < array.length; j++) {
                int x = array[j] % (int)Math.pow(10, i + 1)/(int)Math.pow(10, i);
                ArrayList q = queue.get(x);
                q.add(array[j]);
                //queue.set(x, q);
            }
            int count = 0;
            for ( int j = 0; j < 10; j++) {
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> q = queue.get(j);
                    array[count] = q.get(0);
                    q.remove(0);
                    count++;
                }
            }
        }
    }*/

    public static void main(String[] args) {
        BasicSort basicSort = new BasicSort();
        int[] arr = {12, 54, 26, 74, 36, 84, 35, 11, 4, 8, 2, 5};
        basicSort.sort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
