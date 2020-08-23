package Java0815;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int count = 0;
            String[][] str = new String[n][2];
            for (int i = 0; i < n; i++) {
                str[i][0] = sc.next();
                str[i][1] = sc.next();
            }
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (str[index][0].equals(str[i][1])) {
                    count++;
                    index = i + 1;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
