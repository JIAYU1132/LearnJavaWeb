package Java06_16;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int j = 1;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n - 1; i++) {
                sb.append((n * (n - 1) + j) + "+");
                j += 2;
            }
            sb.append(n * (n + 1) - 1);
            System.out.println(sb);
        }
    }
}
