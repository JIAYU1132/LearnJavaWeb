package Java_0710;

public class Solution {
        /**
         * 计算你能获得的最大收益
         *
         * @param prices Prices[i]即第i天的股价
         * @return 整型
         *
         * 链接：https://www.nowcoder.com/questionTerminal/9370d298b8894f48b523931d40a9a4aa
         * 来源：牛客网
         *
         * 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。
         * 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，
         * 数组中第i个元素（prices[i]）代表该股票第i天的股价。
         * 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
         * 若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。
         * 输入数值范围：2<=n<=100,0<=prices[i]<=100
         *
         * 示例:
         * 输入
         * 3,8,5,1,7,8
         * 输出
         * 12
         */
        public int calculateMax(int[] prices) {
            int firstBuy = Integer.MAX_VALUE; // 第一次买入的价格
            int afterFirstSell = 0; //第一次卖出后的收益
            int afterSecondBuy = Integer.MIN_VALUE;//第二次买入的后的收益
            int afterSecondSell = 0;//第二次卖出后的收益
            for (int cur : prices) {
                //第一次买入的价格应该是取最小值了
                firstBuy = Math.min(firstBuy, cur);
                //第一次次卖出的价收益应该是第一次卖出的价格减去第一次买入的价格, 找最大值
                afterFirstSell = Math.max(afterFirstSell, cur - firstBuy);
                //第二次买入的收益应该是第一次卖出后的收益减去第二次买入的价格, 找最大值
                afterSecondBuy = Math.max(afterSecondBuy, afterFirstSell - cur);
                //第二次卖出的收益应该是第二次买入后剩下的收益加上当前的价格, 越大越好
                afterSecondSell = Math.max(afterSecondSell, cur + afterSecondBuy);
            }
            return afterSecondSell;
        }
}
