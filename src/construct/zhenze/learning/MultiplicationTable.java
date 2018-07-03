package construct.zhenze.learning;

public class MultiplicationTable {

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                // StringBuilder
                //System.out.print(j + "*" + i + "=" + (j * i))
                //下面这段代码是上面的这段代码的简化！！
                String block = String.format("%d*%d=%d\t", j, i, i * j);
                System.out.print(block);
            }
            System.out.println();
        }
    }
}
