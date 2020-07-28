package Java06_09;

//// 删数
//有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。
// 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
//
//        输入描述：
//        每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
//
//        输出描述：
//        一行输出最后一个被删掉的数的原始下标位置。

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int index = 0;
            while (list.size() > 1) {

                index = (index + 2) % list.size();
                // 注意这里是每次下标加2, 因为删掉一个数以后, 后面的元素会顶上来
                list.remove(index);
            }
            System.out.println(list.get(0));
        }
    }
}
