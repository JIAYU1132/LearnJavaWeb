package Java06_07;

import java.util.Scanner;

// 设计一个算法求最小公倍数
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(func(n, m));
        }
    }
    public static int func(int n, int m) {
        if (m > n) {
            if (m % n == 0) {
                return m;
            }
            for (int i = 1; i < n; i++) {
                if (m * i % n == 0) {
                    return m * i;
                }
            }
            return m * n;
        } else if (n > m){
            if (n % m == 0) {
                return n;
            }
            for (int i = 1; i < m; i++) {
                if (n * i % m == 0) {
                   return n * i;
                }
            }
            return n * m;
        } else {
            return m;
        }
    }

}
