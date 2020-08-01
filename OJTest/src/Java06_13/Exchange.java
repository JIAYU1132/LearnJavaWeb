package Java06_13;

public class Exchange {

    // 不创建临时变量, 交换数组中的两个数
     // a = 2; b = 3;
    // a + b
    public int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0] + AB[1];
        AB[1] = AB[0] - AB[1];;
        AB[0] = AB[0] - AB[1];
        return AB;
    }
}
