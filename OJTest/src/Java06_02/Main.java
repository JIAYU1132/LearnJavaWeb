package Java06_02;

import java.util.Scanner;

// 空瓶子
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(anotherMethod(n));
//            int count = 0;
//            while (n >= 3) {
//                n -= 3;
//                n += 1;
//                count++;
//            }
//            if (n == 2) {
//                count++;
//                n = 0;
//            }
//            if (n == 1 || n == 0) {
//                System.out.println(count);
//            }
        }
    }

    // 递归实现
    // f(1) = 0
    // f(2) = 1
    // f(3) = 1
    // f(4) = f(2) + 1
    // f(5) = f(3) + 1
    // f(6) = f(2) + 2
    public static int anotherMethod(int n) {
        if (n == 1) {
            return 0;
        }
        if (n >= 2) {
            return anotherMethod(n - 2) + 1;
        }
        return 0;
    }
}
