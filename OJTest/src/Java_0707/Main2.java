package Java_0707;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *
 *
 * 处理：
 *
 *
 * 1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
 *
 *
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 *
 *
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 *
 * 输入
 * E:\V1R2\product\fpgadrive.c   1325
 * 输出
 * fpgadrive.c 1325 1
 */
public class Main2 {
        public static void main(String[] atgs) {
            Scanner sc=new Scanner(System.in);
            Map<String, Integer> map=new LinkedHashMap<String, Integer>();
            while(sc.hasNext()){
                String str=sc.next();
                int linenum=sc.nextInt();
                String[] arr=str.split("\\\\");  //根据\切割
                String s=arr[arr.length-1];
                if(s.length()>16)  //截取
                    s=s.substring(s.length()-16);
                String key=s+" "+linenum;
                int value=1;
                if(map.containsKey(key))
                    map.put(key, map.get(key)+1);
                else {
                    map.put(key, value);
                }
            }
            int count=0;
            for(String string:map.keySet()){
                count++;
                if(count>(map.keySet().size()-8)) //输出最后八个记录
                    System.out.println(string+" "+map.get(string));
            }
        }
}
