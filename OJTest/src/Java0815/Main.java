package Java0815;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            check(n);
        }
        sc.close();
    }

    private static void check(int n) {

        List<Integer> list = new LinkedList<>();
        int i = 1;
        int index = 0;
        while (i <= n || i * 4 <= n) {
            String[] s = String.valueOf(i).split("");
            StringBuilder sb = new StringBuilder();
            for (int j = s.length - 1; j >= 0; j--) {
                sb.append(s[j]);
            }
            int res = Integer.parseInt(sb.toString());
            if (res == i * 4) {
                index++;
                list.add(i);
                list.add(res);
            }
            i++;
        }
        System.out.println(index);
        for (int j = 0; j < list.size(); j += 2) {
            System.out.println(list.get(j) + " " + list.get(j + 1));
        }
    }
}
