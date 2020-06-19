package Java05_30;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //  假设输入的数据为:
        // 4
        // 3 1 10 31
        // hasNextXXX() 和 nextXXX() 读取到 io 数据直到满足条件(空格和换行符), 否则阻塞等待
        // io流只能操作一次, hasNextXXX() 实际上不操作(不读取), 只判断; nextXXX() 是读取一下, 然后 io 流跑到下一个读取的位置
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                int ret = sc.nextInt();
                System.out.println(ret);
            }
        }

        //  假设输入的数据为:
        // 4
        // 3 1 10 31
        while (sc.hasNextLine()) {
            String s = sc.nextLine(); // 4
            String ret = sc.nextLine(); // 3 1 10 31
        }
    }
}

