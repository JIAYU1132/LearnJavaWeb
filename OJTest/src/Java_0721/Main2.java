package Java_0721;

import java.util.*;

// 单词倒排

/**
 * 对字符串中的所有单词进行倒排。
 *
 * 说明：
 *
 * 1、构成单词的字符只有26个大写或小写英文字母；
 *
 * 2、非构成单词的字符均视为单词间隔符；
 *
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 *
 * 4、每个单词最长20个字母；
 *
 *
 * 输入描述:
 * 输入一行以空格来分隔的句子
 *
 *
 *
 * 输出描述:
 * 输出句子的逆序
 *
 * 示例1
 * 输入
 * I am a student
 * 输出
 * student a am I
 */
public class Main2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] c = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c.length; i++) {
                if (c[i] >= 'a' && c[i] <= 'z' || c[i] >= 'A' && c[i] <= 'Z') {
                    sb.append(c[i]);
                } else {
                    //为其他字符, 假如空格到sb
                    sb.append(" ");
                }
            }
            String str2 = sb.toString();
            // 去掉左右两端的空格
            str2 = str2.trim();
            String[] res = str2.split(" ");
            // 然后从后往前打印
            for (int i = res.length - 1; i >= 0; i--) {
                System.out.print(res[i] + " ");
            }
        }
    }
}