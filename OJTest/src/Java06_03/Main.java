package Java06_03;

import java.util.Scanner;

// 字符串中找出连续最长的数字串
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int max = 0;
            int count = 0;
            int last = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    count++;
                    if (count > max) {
                        max = count;
                        last = i;
                    }
                } else {
                    count = 0;
                }
            }
            System.out.println(s.substring(last - max + 1, last + 1));
        }
    }
}
