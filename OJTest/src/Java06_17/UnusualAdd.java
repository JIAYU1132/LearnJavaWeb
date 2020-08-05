package Java06_17;

// 另类加法
// 不使用算术运算符求两个数相加
// 2^3
// 0010 ^ 0011 -> 0001
// 0010 & 0011 -> (如果有1, 就需要进位) 0010 -> 0010 << 1 -> 0100
// 0100 ^ 0001 -> 0101
// 0100 & 0001 -> 0000 -> 没有1 说明现在这个二进制数, 就是所给的两个数相加得到的

public class UnusualAdd {
    public int addAB(int A, int B) {
        // write code here
        while (B != 0) {
            int sum = A ^ B;
            int tmp = (A & B) << 1; //表示进位,
            // 如果进位为0, 直接返回sum, 如果进位不为0, 继续异或sum和tmp
            A = sum;
            B = tmp;
        }
        return A;
    }
}
