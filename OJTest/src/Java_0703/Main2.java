package Java_0703;

import java.util.Scanner;

/**
 * 密码要求:

 * 1.长度超过8位

 * 2.包括大小写字母.数字.其它符号,以上四种至少三种

 * 3.不能有相同长度大于等于2的子串重复
 *
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 *
 * 输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * OK
 * NG
 * NG
 * OK
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (checkedLength(str) && checkedKinds(str) && checkedRepeat(str)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    private static boolean checkedRepeat(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            String substr = str.substring(i, i + 3);
            if (str.substring(i + 1).contains(substr)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkedKinds(String str) {
        int num = 0;
        int lowerCaseNum = 0;
        int upperCaseNum = 0;
        int otherNum = 0;
        int sum = 0;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                num = 1;
                continue;
            } else if (c[i] >= 'a' && c[i] <= 'z') {
                lowerCaseNum = 1;
                continue;
            } else if (c[i] >= 'A' && c[i] <= 'Z') {
                upperCaseNum = 1;
                continue;
            } else {
                otherNum = 1;
                continue;
            }
        }
        sum = num + lowerCaseNum + upperCaseNum + otherNum;
        return sum >= 3 ? true : false;
    }

    private static boolean checkedLength(String str) {
        if (str == null || str.length() <= 8) {
            return false;
        }
        return true;
    }
}
