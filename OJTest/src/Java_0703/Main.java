package Java_0703;

import javafx.scene.transform.Scale;

import java.util.Scanner;

///守形数
//守形数是这样一种整数，它的平方的低位部分等于它本身。 比如25的平方是625，低位部分是25，因此25是一个守形数。 编一个程序，判断N是否为守形数。
//
//输入描述:
//输入包括1个整数N，2<=N<100。
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (String.valueOf(n * n).endsWith(String.valueOf(n))) {
                System.out.println("Yes！");
            } else {
                System.out.println("No!");
            }
        }
    }
}
