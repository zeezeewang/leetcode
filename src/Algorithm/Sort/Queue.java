package Algorithm.Sort;

public class Queue {

    private static int num = 0;//方案次数
    private static final int MaxQueue = 8;
    private static int[] cols = new int[MaxQueue];

    private void getcount(int n) {
        boolean[] rows = new boolean[MaxQueue];
        for (int m = 0; m < n; m++) {
            rows[cols[m]] = true;
            int d = n - m;
            //斜上.
            if (cols[m] - d >= 0) {
                rows[cols[m] - d] = true;
            }
            //斜下
            if (cols[m] + d <= (MaxQueue - 1)) {
                rows[cols[m] + d] = true;
            }
        }
        for (int i = 0; i < MaxQueue; i++) {
            if (rows[i]) {
                continue;
            }
            cols[n] = i;
            if (n < MaxQueue - 1) {
               getcount(n + 1);
            }else {
                num++;
                printQueue();
            }
        }
    }
    private void printQueue(){
        System.out.println("第" + num + "方案");
        for (int i = 0 ;i < MaxQueue; i++) {
            for (int j = 0; j < MaxQueue; j++) {
                if (i == cols[j]) {
                    System.out.print("0 ");
                }else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.getcount(0);
    }
}