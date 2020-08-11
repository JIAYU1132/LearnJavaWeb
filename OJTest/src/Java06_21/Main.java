package Java06_21;

import java.util.Scanner;

//DNA序列

/**

 * 一个DNA序列由A/C/G/T四个字母的排列组合组成.
 * G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
 *
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 *
 * 输入:
 * AACTGTGCACGACCTGA
 * 5
 * 输出:
 * GCACG
 */
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next();
            int n = sc.nextInt();
            if (str.length() == n) {
                System.out.println(str);
            }
            int max = 0;
            String res = "";
            for (int i = 0; i < str.length() - n; i++) {
                int count = 0;
                String tmp = str.substring(i, i + n);
                for (char c : tmp.toCharArray()) {
                    if (c == 'C' || c == 'G') {
                        count++;
                    }
                }
                    if (count > max) {
                        res = tmp;
                        max = count;
                    }
            }
            System.out.print(res);
        }
    }
}
