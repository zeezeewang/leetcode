package Construct.zhenze.learning;

import java.util.Scanner;

class 猜数字游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个1-100之间的整数：");
        int guessNum = (int) (Math.random() * 10) + 1;
        while (true) {
            int result = sc.nextInt();
            if (result > guessNum) {
                System.out.println("大了");
            } else if (result < guessNum) {
                System.out.println("小了");
            } else {
                System.out.println("中了");
                break;
            }
        }
    }
}
