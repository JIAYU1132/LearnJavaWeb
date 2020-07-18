package Java06_04;


import java.util.Scanner;

// 买苹果(牛客)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(fun(n));
        }
    }

    private static int fun(int n) {
        if (n % 2 != 0 || n < 6 || n == 10) {
            return -1;
        }
        if (n % 8 == 0) {
            return n / 8;
        } else {
            // 如果不能被 8 整除, 如果余数是2, 那就从前面的两个8里面取出来两个2, 和余数一起凑成一个6, 然后加一返回
            // 如果余数是4, 那就从前面的一个8里面取出来一个2, 和余数组成一个6, 然后加一返回
            // 如果余数是6, 直接加一返回即可
            return n / 8 + 1;
        }
    }
}
