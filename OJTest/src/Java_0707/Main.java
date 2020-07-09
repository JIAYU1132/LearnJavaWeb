package Java_0707;

import java.util.Scanner;
/*
说反话
给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。

示例
输入
Hello World Here I Come
输出
Come I Here World Hello
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            for (int i = str.length - 1; i >= 0; i--) {
                System.out.print(str[i] + " ");
            }
        }
    }
}
