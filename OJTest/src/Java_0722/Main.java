package Java_0722;

import java.util.HashMap;
import java.util.Scanner;

//乒乓球筐

/**
 * 题目描述
 * nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……现在他需要判别A盒是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量，该怎么办呢？
 *
 * 输入描述:
 * 输入有多组数据。
 * 每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，每个乒乓球用一个大写字母表示，即相同类型的乒乓球为相同的大写字母。
 * 字符串长度不大于10000。
 *
 * 输出描述:
 * 每一组输入对应一行输出：如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出“Yes”；否则输出“No”。
 *
 * 示例
 * 输入
 * ABCDFYE CDE
 * ABCDGEAS CDECDE
 * 输出
 * Yes
 * No
 */
public class Main {
    // write your code here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            String[] sA = str[0].split("");
            String[] sB = str[1].split("");
            HashMap<String,Integer> mapA = new HashMap<>();
            HashMap<String,Integer> mapB = new HashMap<>();
            for (String s1:sA){
                if (!mapA.containsKey(s1)){
                    mapA.put(s1,1);
                }else {
                    mapA.put(s1,mapA.get(s1)+1);
                }
            }
            for (String s1:sB){
                if (!mapB.containsKey(s1)){
                    mapB.put(s1,1);
                }else {
                    mapB.put(s1,mapB.get(s1)+1);
                }
            }
            int count=0;
            for (int i = 0;i<sB.length;i++){
                if (mapA.containsKey(sB[i])){
                    mapA.put(sB[i],mapA.get(sB[i])-1);
                    if (mapA.get(sB[i])<0){
                        System.out.println("No");
                        break;
                    }
                    count++;
                }else {
                    System.out.println("No");
                    break;
                }
            }
            if (count==sB.length){
                System.out.println("Yes");
            }
        }
    }
}