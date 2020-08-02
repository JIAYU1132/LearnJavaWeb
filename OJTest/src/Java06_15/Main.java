package Java06_15;

import java.util.Scanner;

// 和奥巴马一起编程
//aaaaaaaaa
//a        a
//a        a
//a        a
//aaaaaaaaaa
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String c = sc.next();
            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
            for (int i = 0; i < Math.ceil((double) n / 2 - 2); i++) {
                System.out.println();
                for (int j = 0; j < n; j++) {
                    if (j == 0 || j == n - 1) {
                        System.out.print(c);
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
        }
    }
}
