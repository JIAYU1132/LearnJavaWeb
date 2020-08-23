package Java0815;

import java.util.Map;
import java.util.Scanner;

public class Main4 {
    // 要让利润最大化, 那就要让车尽量去最大利润的地方
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//表示车的数量
            int a = sc.nextInt();//表示A地订单数量
            int b = sc.nextInt();//表示B地订单数数量
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                int sum = arr[i][0] * a + arr[i][1] * b;//表示第i个的利润
                max = Math.max(max, sum);
            }
            System.out.println(max);
        }
        sc.close();
    }
}
