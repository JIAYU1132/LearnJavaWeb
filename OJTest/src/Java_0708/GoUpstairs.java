package Java_0708;

import java.util.*;

public class GoUpstairs {
    public int countWays(int n) {
        // write code here
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for (int i = 3; i < n; i++) {
            arr[i] = (((arr[i - 1] + arr[i - 2]) % 1000000007 + arr[i - 3]) % 1000000007) % 1000000007;
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        GoUpstairs s = new GoUpstairs();
        System.out.println(s.countWays(4));
    }
}
