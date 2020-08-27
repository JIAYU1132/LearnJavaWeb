package Java0821;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        int[][] a = new int[len][len];
        int n = len * len;
        for(int k = 0, j = len; k < j; j--,k++){
            for (int i = k; i < j; i++)
                a[k][i] = fun(n--);
            for (int i = k + 1; i < j; i++)
                a[i][j-1] = fun(n--);
            for(int i = j - 2; i >= k; i--)
                a[j-1][i] = fun(n--);
            for(int i = j - 2; i > k; i--)
                a[i][k] = fun(n--);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++)
                System.out.print(a[i][j]+" ");
                System.out.println();
        }
    }
    public static int fun(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fun(n - 1) + fun(n - 2);
    }
}
