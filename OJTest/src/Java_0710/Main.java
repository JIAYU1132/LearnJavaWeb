package Java_0710;

import java.util.*;

// 坏键盘
public class Main {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine().toUpperCase();
            String str2 = sc.nextLine().toUpperCase();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str2.length(); i++){
                if (!str2.contains(String.valueOf(str1.charAt(i)))) {
                    if (!sb.toString().contains((String.valueOf(str1.charAt(i))))) {
                        sb.append(str1.charAt(i));
                    }
                }
            }
            System.out.println(sb);
        }
    }
}