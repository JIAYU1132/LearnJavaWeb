package Java06_22;

import java.util.ArrayList;
import java.util.List;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] arr = new boolean[n];
        for(int i = 0; i < n; i++) {
            if (s.contains(p[i])) {
                arr[i] = true;
            } else {
                arr[i] = false;
            }
        }
        return arr;
    }
}
