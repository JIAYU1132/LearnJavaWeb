package Java06_06;

import java.util.Scanner;

// 计算糖果
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int A = (a + c) / 2;
            int B = A - a;
            int C = B - b;
            if (B + C == d ) {
                System.out.print(A + " ");
                System.out.print(B + " ");
                System.out.print(C);
            } else {
                System.out.println("No");
            }
        }
    }
}
