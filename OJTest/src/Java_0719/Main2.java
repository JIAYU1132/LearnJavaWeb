package Java_0719;

import java.util.Scanner;

//字符串加解密

/**
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。

 * 输入描述:
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 *
 * 输出描述:
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 *
 * 示例1
 *
 * 输入
 * abcdefg
 * BCDEFGH
 *
 * 输出
 * BCDEFGH
 * abcdefg
 */
public class Main2 {

    public static final String str1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final String str2 = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza1234567890";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();//要加密的密码
            String str2 = sc.nextLine();//要解密的密码
            char[] c1 = str1.toCharArray();
            char[] c2 = str2.toCharArray();
            System.out.println(Encrypt(c1));
            System.out.println(unEncrypt(c2));
        }
        sc.close();
    }

    //解密
    private static String Encrypt(char[] c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == c[i]) {
                    sb.append(str2.charAt(j));
                }
            }
        }
        return sb.toString();
    }


    //加密
    private static String unEncrypt(char[] c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) == c[i]) {
                    sb.append(str1.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
