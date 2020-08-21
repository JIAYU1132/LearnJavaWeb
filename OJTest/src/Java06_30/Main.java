package Java06_30;

import java.util.Scanner;

// 对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。
//输入描述:
//每行输入数据包括一个正整数n(0<n<40000)
//输出描述:
//对于每个输入数据，计算其各位数字之和，以及其平方值的数字之和，输出在一行中，
// 之间用一个空格分隔，但行末不要有空格

//输入
//4
//12
//97
//39999
//输出
//4 7
//3 9
//16 22
//39 36
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = n * n;
            int sum1 = 0;
            while (n > 0) {
                sum1 += n % 10;
                n /= 10;
            }
            int sum2 = 0;
            while (m > 0) {
                sum2 += m % 10;
                m /= 10;
            }
            System.out.println(sum1 + " " + sum2);
        }
    }
}