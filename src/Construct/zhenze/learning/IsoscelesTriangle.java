package Construct.zhenze.learning;

public class IsoscelesTriangle {

    public static void main(String[] args) {

        for (int m = 5; m <= 31; m += 2) {

            for (int i = 1; i <= m; i++) {
                StringBuffer sb = new StringBuffer();
                for (int k = 0; k <= m - i; k++) {
                    sb.append(" ");
                }
                for (int j = 1; j <= i; j++) {
                    sb.append("* ");
                }
                System.out.println(sb);
            }

            System.out.println();
        }
    }
}
