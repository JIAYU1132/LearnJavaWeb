package Java0815;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//表示订单数量
            int m = sc.nextInt();//表示已知关系数量
            Set<Integer> set = new TreeSet<>();
            List<Set<Integer>> list = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                if (set.contains(num1) || set.contains(num2)) {
                    //如果这个set中有这两个元素其中一个, 说明这两个元素是一个小区的, 就把他们放到一个set中
                    set.add(num1);
                    set.add(num2);
                } else {
                    //如果这个set中不包含这两个元素, 就重新new一个set, 把这两个set放进去, 作为另外一个小区, 并且count++, 记录个数
                    count++;
                    //TODO
                    list.add(new HashSet<>(set));
                    set.add(num1);
                    set.add(num2);
                }
            }
            //循环完毕, 所有的订单已经按照关系存到相同的小区了, 此时直接打印即可
            System.out.println(count);
            for (int i = 0; i < count; i++) {
                //TODO 这里打印之前创建的每一个set的内容, 因为使用的是TreeSet, 所以直接是默认排序好的
                System.out.println(list);
            }
        }
        sc.close();
    }
}
