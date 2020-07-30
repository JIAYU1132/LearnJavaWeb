package Java06_11;

// 机器人走方格
// 每个格子他只能向右或者向下走, 也就是对于每个格子他只有两种走法, 等他走到下一个格子的时候, 递归加起来就行了
public class Robot {

    public int countWays(int x, int y) {
        // write code here
        if (x == 1 || y == 1) {
            return 1;
        }
        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}
