package Java06_15;

import java.math.BigInteger;
import java.util.Scanner;

// 超长正整数相加
// 输入
//99999999999999999999999999999999999999999999999999
//1
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            BigInteger n1 = new BigInteger(str1);
            BigInteger n2 = new BigInteger(str2);
            System.out.println(n1.add(n2));
        }
    }
}