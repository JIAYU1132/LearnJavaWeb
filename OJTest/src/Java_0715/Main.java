package Java_0715;

import java.util.Scanner;

/**
 * 回文串
 *
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串。
 *
 * 输入描述:
 * 一行一个由小写字母构成的字符串，字符串长度小于等于10。
 *
 *
 * 输出描述:
 * 输出答案(YES\NO).
 * 示例1
 * 输入
 * coco
 * 输出
 * YES
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int flag = 0;
            int left = 0;
            int right = str.length() - 1;
            while (left <= right) {
                if (str.charAt(left) != str.charAt(right)) {
                    if (left + 1 <= right && str.charAt(left + 1) == str.charAt(right)) {
                        left++;
                        flag++;
                    } else if (right - 1 >= left && str.charAt(right - 1) == str.charAt(left)) {
                        right--;
                        flag++;
                    } else {
                        flag += 2;
                        break;
                    }
                } else {
                    left++;
                    right--;
                }
            }
            if (flag < 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
