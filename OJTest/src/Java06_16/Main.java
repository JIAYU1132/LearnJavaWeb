package Java06_16;

import java.util.*;

// 组个最小数

// 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。例如：
// 给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。

// 输入
//2 2 0 0 0 3 0 0 1 0
//输出
//10015558

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            int[] n = new int[10];
            for (int i = 0; i < n.length; i++) {
                n[i] = sc.nextInt();
            }
            int i = 0;
            for (int k = 0; k < n.length; k++) {
                while (n[i] != 0) {
                    list.add(i);
                    n[i]--;
                }
                i++;
            }
            if (list.get(0) == 0) {
                for (int m = 0; m < list.size(); m++) {
                    if (list.get(m) != 0) {
                      list.set(0, list.get(m));
                      list.set(m, 0);
                        break;
                    }
                }
            }
            for (int m = 0; m < list.size(); m++) {
                System.out.print(list.get(m));
            }
        }
    }
}
