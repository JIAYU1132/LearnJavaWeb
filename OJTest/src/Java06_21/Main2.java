package Java06_21;

import java.util.Scanner;

//百万富翁问题

/**
 * 一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下：我每天给你10 万元，你第一天给我1 分钱，第二天2 分钱，
 * 第三天4 分钱……
 * 这样交换 30 天后，百万富翁交出了多少钱？陌生人交出了多少钱？（注意一个是万元，一个是分）
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.print(10 * 30 + " " );
        System.out.println((int)Math.pow(2, 30) - 1);

    }
}
