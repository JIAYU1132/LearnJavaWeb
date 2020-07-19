package Java06_06;

// n 个数里出现次数大于等于 n / 2 的数

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            HashMap<Integer, Integer> map = new HashMap<>();
            String[] strs = sc.nextLine().split(" ");
            for (int i = 0; i < strs.length; i++) {
                int n = Integer.valueOf(strs[i]);
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= strs.length / 2) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
