package Java06_10;

import java.util.Scanner;

// 数字颠倒
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            char[] c = sc.nextLine().toCharArray();
            for (int i = c.length - 1; i >= 0; i--) {
                System.out.print(c[i]);
            }
        }
    }
}
