package Java06_04;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 删除公共字符串

// 方法一: 通过 String 的 replaceAll 来操作
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String A = sc.nextLine();
            String B = sc.nextLine();
            for (int i = 0; i < A.length(); i++) {
            A = A.replaceAll(B.substring(i, i + 1), "");
            }
            System.out.println(A);
        }
    }

    // 通过判断第一个字符串中的每个字符是否在第二个字符串中存在, 如果不存在就直接打印(不加换行符)
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] c = sc.nextLine().toCharArray();
            String B = sc.nextLine();
            for (int i = 0; i < c.length; i++) {
                if (!B.contains(String.valueOf(c[i]))) {
                    System.out.print(c[i]);
                }
            }
        }
    }
}
