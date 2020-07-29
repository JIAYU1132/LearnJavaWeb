package Java06_10;


import java.util.Scanner;

// 输入一个整数, 求阶乘后末尾有几个0
public class Main {
    // 输入数字过大, 超过时间限制, 作废!!!! 此题不能用递归实现!!!!!
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int n = sc.nextInt();
//            long tmp = jiecheng(n);
//            System.out.println(tmp);
//            int count = 0;
//            while (tmp % 10 == 0) {
//                count++;
//                tmp /= 10;
//            }
//            System.out.println(count);
//        }
//    }
//
//    private static long jiecheng(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        return n * jiecheng(n - 1);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int count = 0;
            //能被5（5^1）整除的提供1个0
            //能被25（5^2）整除的提供2个0
            //能被125（5^3）整除的提供3个0
            //能被625（5^4）整除的提供4个0
            for (int i = 0; i < n; i++) {
                    n /= 5;
                    count += n;
            }
            System.out.println(count);
        }
    }
}
