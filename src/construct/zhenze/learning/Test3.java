package construct.zhenze.learning;

public class Test3 {

    public static void main(String[] args) {
        int k = 5;
        int n = 10;
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i + 1;
        }
        print("彩球数组: ", arr1);

        int[] arr2 = new int[k];
        for (int i = 0; i < arr2.length; i++) {
            int r = (int) (Math.random() * n);
            arr2[i] = arr1[r];
            arr1[r] = arr1[n - 1];
            n--;
        }
        print("抽奖数组: ", arr2);
    }

    private static void print(String title, int[] arr) {
        System.out.print(title);
        //for(int i = 0;i < arr.length;i++)
        //下面是这段的简写！！！
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
