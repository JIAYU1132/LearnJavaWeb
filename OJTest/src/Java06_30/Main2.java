package Java06_30;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
计票统计
输入描述:
输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。

输出描述:
每行输出候选人的名字和得票数量。

输入
4
A B C D
8
A B C D E F G H

输出
A : 1
B : 1
C : 1
D : 1
Invalid : 4
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(); // 候选人人数
            Map<String, Integer> map = new LinkedHashMap<>(); // 用来统计投票结果
            for (int i = 0; i < n; i++) {
                map.put(sc.next(), 0);
            }
            map.put("Invalid", 0);

            int m = sc.nextInt(); // 统计投票次数
            for (int i = 0; i < m; i++) {
                String s = sc.next();
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put("Invalid", map.get("Invalid") + 1);
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
