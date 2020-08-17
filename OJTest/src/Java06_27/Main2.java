package Java06_27;

import java.util.Scanner;

/**
 * 最高分是多少
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。
 * 当然，老师有时候需要更新某位同学的成绩.
 *
 * 输入描述：
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 *
 * 输出描述：
 * 对于每一次询问操作，在一行里面输出最高成绩.
 *
 * 输入：
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * 输出：
 * 5
 * 6
 * 5
 * 9
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(); // 学生的数目
            int m = sc.nextInt(); // 操作的数目
            int[] arr = new int[n]; // 存放n个学生的成绩
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            String[] strs = new String[m];
            int[] a = new int[m];
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                strs[i] = sc.next();
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                if (strs[i].equals("Q")) {
                    if (a[i] < b[i]) {
                        System.out.println(getMax(arr, a[i], b[i]));
                    } else {
                        System.out.println(getMax(arr, b[i], a[i]));
                    }
                } else if (strs[i].equals("U")) {
                    arr[a[i] - 1] = b[i];
                }
            }

            }
        }

    private static int getMax(int[] arr, int i, int j) {
        int max = arr[i - 1];
        for (int k = i; k <= j - 1; k++) {
            max = Math.max(arr[k], max);
        }
        return max;
    }
}
