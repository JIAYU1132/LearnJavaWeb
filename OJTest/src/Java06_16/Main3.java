package Java06_16;

import java.util.Scanner;

/** 神奇的口袋
 * 【神奇的口袋】有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。John现在有n个想要得到的物品，每个物品的体积
 * 分别是a1，a2……an。John可以从这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。现在的问题
 * 是，John有多少种不同的选择物品的方式。
 *
 * 输入描述：
 * 输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。
 * 接下来的n行，每行有一个1到40之间的正整数，分别给出a1，a2……an的值
 * 。
 * 输出描述：
 * 输出不同的选择物品的方式的数目。
 *
 * 示例1：
 * 输入
 * 3
 * 20
 * 20
 * 20
 * 输出
 * 3
 *
 */

// 思路: 采用递归的思想
    // 1. 物品 n 个吗逐个放入 arr 数组中
    // 2. 递归(剩余物品的重量, 剩余可选物品的个数)
    //    递归过程:
    //    (1) 从后往前装, 装上 arr[n] 后仍然可装, 就递归(s - arr[n], n - 1)
    //    (2) 若装了 arr[n] 后不可装了, 则删除这个包, 递归下一个 count(s, n - 1)
public class Main3 {

    private static int tmp;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            count(40, n);
            System.out.println(tmp);
        }
    }

    private static void count(int s, int n) {
        if (s == 0) {
            tmp++;
            return;
        }
        if (s < 0 || s > 0 && n < 1) {
            return;
        }
        count(s - arr[n], n - 1);
        count(s, n - 1);
    }
}
