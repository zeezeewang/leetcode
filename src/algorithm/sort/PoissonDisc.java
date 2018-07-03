package algorithm.sort;

public class PoissonDisc {
    private int b1 = 12;
    private int b2 = 8;
    private int b3 = 5;
    private int m = 6;

    private void backBottle(int bb1, int bb2, int bb3) {
        System.out.println("bb1 = " + bb1 + ", bb2 = " + bb2 + ", bb3 =" + bb3);
        if (bb1 == m || bb2 == m || bb3 == m) {
            System.out.println("find the Bottle");
            return;
        }
       if (bb2 != 0 && bb3 != b3) {
            if (bb2 + bb3 <= b3) {
                backBottle(bb1, 0, bb2 + bb3);
            } else {
                backBottle(bb1, bb2 - (b3 - bb3), b3);
            }
        } else if (bb3 == b3) {
            if (bb3 + bb1 <= b1) {
                backBottle(bb1 + bb3, bb2, 0);
            } else {
                backBottle(b1, bb2, bb3 - (b1 - bb1));
            }
        } else if (bb2 == 0) {
            if (bb1 >= b2) {
                backBottle(bb1 - b2, b2, bb3);
            } else {
                backBottle(0, bb1, bb3);
            }
        }
    }

    public static void main(String[] args) {
        PoissonDisc poissonDisc = new PoissonDisc();
        poissonDisc.backBottle(12, 0, 0);
    }
}
