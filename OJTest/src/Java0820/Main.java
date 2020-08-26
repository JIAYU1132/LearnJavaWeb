package Java0820;

import java.util.*;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();//表示任务数
            int[] l = new int[n];//表示每个任务开始的时间
            int[] r = new int[n];//表示每个任务结束的时间
            int[] w = new int[n];//表示每个任务获得的金钱
            for (int i = 0; i < n; i++) {
                l[i] = sc.nextInt();
                r[i] = sc.nextInt();
                w[i] = sc.nextInt();
            }

            int sum = w[0];// 记录最多的金钱数量
            int j = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                j = i + 1;
                while (j < n) {
                    if (l[j] > r[i]) {
                        sum += w[j];
                        break;
                    } else {
                        j++;
                    }
                }
                max = Math.max(max, sum);
            }
            System.out.println(max);
        }
    }
}