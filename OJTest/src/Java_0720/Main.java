package Java_0720;

import java.util.*;


/**
 * 电话号码
 *
 * 上图是一个电话的九宫格，如你所见一个数字对应一些字母，
 * 因此在国外企业喜欢把电话号码设计成与自己公司名字相对应。
 * 例如公司的Help Desk号码是4357，因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。
 * 同理，TUT-GLOP就代表888-4567、310-GINO代表310-4466。
 * NowCoder刚进入外企，并不习惯这样的命名方式，现在给你一串电话号码列表，请你帮他转换成数字形式的号码，并去除重复的部分。
 *
 */
public class Main{
    private static final String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String str2 = "22233344455566677778889999";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Set<String> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                char[] c = sc.next().replace("-", "").toCharArray();
                for (int j = 0; j < c.length; j++) {
                    if (j == 3) {
                        sb.append("-");
                    }
                    if (Character.isLetter(c[j])) {
                        sb.append(str2.charAt(str1.indexOf(c[j])));
                    } else {
                        sb.append(c[j]);
                    }
                }
                set.add(sb.toString());

            }
            for (String s : set) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}