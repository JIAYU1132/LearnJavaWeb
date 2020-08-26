package Java0820;

import java.util.*;

/**
 * 小A的购买了一批服务器，他准备将这些服务器租用出去。
 * 每一个服务器有一个固定的带宽，人们根据自己需要的带宽来租用这些服务器。
 * 一台服务器只能租给一个人。
 * 小A现在有n个空闲的服务器，第 i 个服务器拥有ai的带宽。有m个客户来租服务器，第 i 位客户需要带宽至少为bi的服务器，
 * 并且愿意花ci元作为预算。
 * （服务器带宽独立不可叠加，若不能成功租出则输出0） 小A可以选择拒绝一些人，
 * 现在，小A想知道自己的服务器最多能租多少钱？
 *
 *
 * 输入第一行包含两个数n,m
 *
 * 接下来1行n个数，第i个数ai代表第i个服务器的带宽大小。
 *
 * 接下来m行，每行两个数bi,ci，代表客户需求的带宽大小和他的预算。
 *
 * n,m≤1000 , 1≤ai,bi,ci≤1000
 *
 *
 * 3 4
 * 1 2 3
 * 2 1
 * 3 2
 * 3 3
 * 1 1
 */

public class Mian2 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//表示n个空闲的服务器
            int m = sc.nextInt();//表示m个客户
            List<Integer> list = new LinkedList<>();//表示每个服务器的带宽大小
            int[][] bc = new int[m][m];//表示客户所需要的带宽大小和他的预算
            String s = sc.nextLine();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            for (int i = 0; i < m; i++) {
                bc[i][0] = sc.nextInt();
                bc[i][1] = sc.nextInt();
            }

            Arrays.sort(bc, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            for (int i = 0; i < m; i++) {
                System.out.println(bc[i][0] + " "+ bc[i][1]);
            }
            int max = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                if (list.contains(bc[i][0])) {
                    if (bc[i][0] != bc[i + 1][0]) {
                        map.put(bc[i][0], bc[i][1]);
                    }
                    while (bc[i][0] == bc[i + 1][0]) {
                        i++;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
