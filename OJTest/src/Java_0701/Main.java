package Java_0701;

//找x

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                map.put(sc.nextInt(), i);
            }
            int tar = sc.nextInt();
                if (map.containsKey(tar)) {
                    System.out.println(map.get(tar));
            } else {
                    System.out.println(-1);
                }
        }
    }
}
