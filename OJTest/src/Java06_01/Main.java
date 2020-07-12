package Java06_01;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 统计回文 (牛客)
public class Main{
    public static void main(String[] arg) {
        List listA = new LinkedList();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String A = s.nextLine();
            String B = s.nextLine();
            int count = 0;
            for (int i = 0; i <= A.length(); i++) {
                StringBuffer sb = new StringBuffer(A);
                sb.insert(i, B);
                if (isHuiWen(sb.toString())) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isHuiWen(String tmp) {
        char[] c = tmp.toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
                if (c[i] != c[j]) {
                    return false;
                }
                i++;
                j--;
            }
        return true;
    }
}