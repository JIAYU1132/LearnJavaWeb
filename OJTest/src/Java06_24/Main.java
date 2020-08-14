package Java06_24;

import java.util.Scanner;

// 统计每个月兔子的总数
//有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
// 假如兔子都不死，问每个月的兔子总数为多少？

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        while (sc.hasNextInt()) {
            int mounth = sc.nextInt();
            if (mounth == 1 || mounth == 2) {
                System.out.println(1);
            }
            int oneMounth = 1;
            int twoMounth = 0;
            int baby = 1;
            int adult = 1;
            for (int i = 4; i <= mounth; i++) {
                // 1. 两个月大的变成了有生育能力的adult
                adult += twoMounth;
                // 2. 一个月大的变成了两个月大的
                twoMounth = oneMounth;
                // 3. adult生出一个月大的兔子
                oneMounth = adult;
                // 4. 当月小兔子的总个数
                baby = oneMounth + twoMounth;
            }
            System.out.println(baby + adult);
        }
    }
}
