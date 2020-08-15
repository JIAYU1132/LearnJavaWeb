package Java06_25;

//到底买不买
/**
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。
 * 于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？
 * 如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
 * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色.
 * 例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了
 * 全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 */

//如果可以买, 就在一行输出"Yes"以及有多少多余的珠子, 如果不可以买, 就输出"No"以及缺了多少颗珠子
//ppRYYGrrYBR2258
//YrR8RrY

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            Map<Character, Integer> map = new HashMap<>();
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int less = 0;
            // 用来判断能否可以买, 每次在map没找到一个,less就加1, 如果到最后, less不等于0, 那么就是不可以买, less的值就是缺了的珠子数
            //  如果less最后等于0, 那么就是可以买, 多余的珠子数就是str1.length() -str2.length()
            for (int i = 0; i < str1.length(); i++) {
                char c = str1.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            // 如果找到了, 就把这个key对应的value减1
            for (int i = 0; i < str2.length(); i++) {
                char c = str2.charAt(i);
                if (map.containsKey(c)) {
                    // 每次找到一个, 就把map中这个key对应的value值减1
                    if (map.get(c) > 0) {
                        map.put(c, map.get(c) - 1);
                    } else {
                        // 如果key所对应的value值不大于0了, 说明这个珠子已经没有了, 这是less就要++
                        less++;
                    }
                } else {
                    // 如果没找到这个珠子, less++
                    less++;
                }
            }
            if (less == 0) {
                System.out.println("Yes " + (str1.length() - str2.length()));
            } else {
                System.out.println("No " + less);
            }
        }
    }
}
