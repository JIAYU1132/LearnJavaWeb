package Java0821;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());//表示参赛人数
            String s1 = sc.nextLine();//表示跳高成绩
            String s2 = sc.nextLine();//表示跳远成绩
            String[] str1 = s1.split(" ");
            String[] str2 = s2.split(" ");
            List<String> listHead1 = new ArrayList<>();// 表示跳高在X之前的人
            List<String> listTail1 = new ArrayList<>();//表示跳高在X之后的人
            List<String> listHead2 = new ArrayList<>();//表示跳远在X之前的人
            List<String> listTail2 = new ArrayList<>();//表示跳远在X之后的人
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < str1.length; i++) {
                if (str1[i].equals("X")) {
                    index1 = i;
                }
            }
            for (int i = 0; i < index1; i++) {
                listHead1.add(str1[i]);
            }
            for (int i = index1 + 1; i < str1.length; i++) {
                listTail1.add(str1[i]);
            }
            for (int i = 0; i < str2.length; i++) {
                if (str2[i].equals("X")) {
                    index2 = i;
                }
            }
            for (int i = 0; i < index2; i++) {
                listHead2.add(str2[i]);
            }
            for (int i = index2 + 1; i < str2.length; i++) {
                listTail2.add(str2[i]);
            }
            int good = 1;
            int bad = n;
            for (int k = 0; k < listHead2.size(); k++) {
                if (listHead1.contains(listHead2.get(k))) {
                    good++;
                }
            }
            for (int k = 0; k < listTail2.size(); k++) {
                if (listTail1.contains(listTail2.get(k))) {
                    bad--;
                }
            }
            System.out.println(good++ + " " + bad--);
        }
    }
}
