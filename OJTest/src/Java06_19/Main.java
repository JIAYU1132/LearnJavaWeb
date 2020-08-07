package Java06_19;

import java.util.*;

// 火车进站问题
public class Main {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            list.clear();
            int n = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            out(arr, 0, stack, "", 0);
            Collections.sort(list);// 对list中的结果集排序
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        sc.close();
    }

    private static void out(int[] arr, int i, Stack<Integer> stack, String str, int n) {
        // str储存出站结果, n为出站次数, i为入站次数
        if (n == arr.length) {
            // 如果所有的火车都已出站, 就把这个结果str保存在list中
            list.add(str);
        }
        if (!stack.isEmpty()) {
            // 如果站里现在有火车, 就把这个火车出站
            int tmp = stack.pop();
            out(arr, i, stack, str + tmp + " ", n + 1);
            stack.push(tmp); // 还原现场, 准备另外的可能性
        }
        if (i < arr.length) {
            // 如果站里没有火车, 就让火车先进站
            stack.push(arr[i]);
            out(arr, i + 1, stack, str, n);
            stack.pop();// 还原现场
        }
    }
}
