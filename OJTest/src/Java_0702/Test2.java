package Java_0702;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        String s1 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";//代表全部参与抽奖的人员编号
        String s2 ="2,5,6";//代表已经中奖的人员编号
        int number = 3;
        select(s1, s2, number);
    }

    private static void select(String s1, String s2, int num) {
        List<String> list = new LinkedList<>(); // 这里要利用插入和删除操作，所以使用LinkedList
        String[] str = s1.split(",");
        String[] res = new String[num]; // 用来存放s2中不存在的人员编号
        int i = 0; // 记录res数组中的下标
        String strs = new String(); // 记录最终记录中二等奖的人员编号
        Random random = new Random(); // 获取随机数字
        for (String s : str) {
            list.add(s);
        }
        // 从s1中随机抽取num个数字，并存入res中
        while (i < num) {
            int tmp = random.nextInt(list.size()); // 随机生成一个[0, list.size - 1]的整数
            if (!s2.contains(list.get(tmp))) {
                res[i] = list.get(tmp);
                i++;
                list.remove(tmp);
                // 如果这个人是二等奖，就把他从list中删除掉，防止下次获取随机数的时候再次获取到这个编号
            }
        }
        for (int j = 0; j < res.length; j++) {
            strs += res[j] + " ";
        }
        System.out.println("二等奖中奖人员: " + strs);
    }
}
