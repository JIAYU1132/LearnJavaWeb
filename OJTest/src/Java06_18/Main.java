package Java06_18;

import java.util.*;

// 洗牌

/**
 * 链接：https://www.nowcoder.com/questionTerminal/5a0a2c7e431e4fbbbb1ff32ac6e8dfa0
 * 来源：牛客网
 *
 * 洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。
 * 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。
 * 首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。
 * 接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，
 * 再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。
 * 接着把牌合并起来就可以了。 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。
 * 首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1。
 * 把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
 * 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。
 *
 * 输入描述:
 * 第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，
 * 第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。
 *
 * 输出描述:
 * 对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
 *
 * 输入
 * 3
 * 3 1
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 3 2
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 2 2
 * 1
 * 1
 * 1
 * 1
 *
 * 输出
 * 1 4 2 5 3 6
 * 1 5 4 3 2 6
 * 1 1 1 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 第一次输入的数T, 表示数组组数
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            // 下一个输入的两个数分别是n和洗牌次数k
            int n = sc.nextInt();
            int k = sc.nextInt();
            // 使用ArrayList来保存牌
            List<Integer> cards = new ArrayList<>();
            List<Integer> cardsLeft = new ArrayList<>(); // 保存左手的第1张到第n张
            List<Integer> cardsRight = new ArrayList<>(); // 保存右手的第n+1张到第2n张
            // 下一次输入的是所有的牌
            for (int j = 0; j < 2 * n; j++) {
                // 全部先存到cards里
                cards.add(sc.nextInt());
            }
            // 这里注意是从下往上取牌的, 所以为了方便操作, 将cards翻转一下, 注意最后得翻转回来
            Collections.reverse(cards);

            for (int j = 0; j < k; j++) {
                // 把上次洗牌得到的左右手的卡片记录都清空
                cardsLeft.clear();
                cardsRight.clear();
                // 先把翻转后的上半堆(即原来的下半堆)放到右手
                for (int l = 0; l < n; l++) {
                    cardsRight.add(cards.get(l));
                }
                // 再把翻转后的下半堆(即原来的上半堆)放到左手
                for (int l = n; l < 2 * n; l++) {
                    cardsLeft.add(cards.get(l));
                }
                // 开始洗牌
                // cardsLeft 和 cardsRight 里面现在各有n张牌
                // 先把cards清空
                cards.clear();
                // 是右手的牌先放
                for (int l = 0; l < n; l++) {
                    cards.add(cardsRight.get(l));
                    cards.add(cardsLeft.get(l));
                }
            }
            // 再把cards翻转一次
            Collections.reverse(cards);
            // 这里的cards里面牌的顺序就是k次洗牌之后的顺序
            System.out.println(
                    cards.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", ""));
        }
    }
}
