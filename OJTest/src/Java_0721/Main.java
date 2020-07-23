package Java_0721;

// 驼峰命名法
/**
 * 从C/C++转到Java的程序员，一开始最不习惯的就是变量命名方式的改变。
 * C语言风格使用下划线分隔多个单词，例如“hello_world”；
 * 而Java则采用一种叫骆驼命名法的规则：除首个单词以外，所有单词的首字母大写，例如“helloWorld”。
 * 请你帮可怜的程序员们自动转换变量名。
 *
 * 输入描述:
 * 输入包含多组数据。
 * 每组数据一行，包含一个C语言风格的变量名。每个变量名长度不超过100。
 *
 * 输出描述:
 * 对应每一组数据，输出变量名相应的骆驼命名法。
 *
 * 示例
 * 输入
 * hello_world
 * nice_to_meet_you
 * 输出
 * helloWorld
 * niceToMeetYou
 *
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '_') {
                    i++;
                    char c = str.charAt(i);
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}