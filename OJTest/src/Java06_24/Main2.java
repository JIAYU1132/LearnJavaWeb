package Java06_24;

import java.util.Scanner;

// 最难的问题

/**

 * NowCoder生活在充满危险和阴谋的年代。为了生存，他首次发明了密码，用于军队的消息传递。
 * 假设你是军团中的一名军官，需要把发送来的消息破译出来、并提供给你的将军。
 * 消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换
 * （例如：消息原文中的每个字母A 都分别替换成字母F)
 * 其他字符不变，并且消息原文的所有字母都是大写的。密码中的字母与原文中的字母对应关系如下。
 * 密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * 原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strs = sc.nextLine();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < strs.length(); i++) {
                char c = strs.charAt(i);
                if (c < 'F' && c >= 'A') {
                    sb.append((char)(c + 21));
                } else if (c > 'E' && c <= 'Z') {
                    sb.append((char)(c - 5));
                } else {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
