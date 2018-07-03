package Construct.Link;

public class DiGui {

    public int add(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + add(n - 1);
        }
    }

    public static void main(String[] args) {
        final DiGui digui = new DiGui();
        final int n = digui.add(100);
        System.out.println(n);
    }
}
