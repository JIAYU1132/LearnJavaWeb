package Java06_11;

// Fibonacci 数列
// 输入一个整数N, 需要多少不才能变成一个斐波那锲数列

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int a = 0;
            int b = 1;
            while (b < n) {
                int tmp = a;
                a = b;
                b = tmp + a;
            }
            // 此时 n 就是出于斐波那锲数 a 和 b 之间的数
            if (n - a > b - n) {
                System.out.println(b - n);
            } else {
                System.out.println(n - a);
            }
        }
    }
}
