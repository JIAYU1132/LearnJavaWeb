package Java06_12;

import java.util.Scanner;

// 个位数统计
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] c = str.toCharArray();
            int[] arr = new int[10];
            for (int i = 0; i < c.length; i++) {
                arr[c[i] - '0']++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    System.out.println(i + ":" + arr[i]);
                }
            }
        }
    }
}
