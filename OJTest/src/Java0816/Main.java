package Java0816;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            List<String> list = new ArrayList<>();
            int index = 0;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].equals("undo")) {
                    if (strs[i + 1].equals("redo")) {
                        list.add(strs[i - 1]);
                    }
                }
                if (!strs[i].equals("undo") && !strs[i].equals("redo")){
                    list.add(strs[i]);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}