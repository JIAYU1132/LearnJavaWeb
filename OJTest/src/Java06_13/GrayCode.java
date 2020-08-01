package Java06_13;

// 生成格雷码
// 什么是格雷码: 任意两个相邻的代码只有一位二进制数不同
// 1 = ["0", "1"]
// 2 = ["00","01","11","10"]
// 依次网上递增, 会发现几个规律
// 1. 数组的长度在随着2的次方增大
// 2. 先给原先的数组前面加0
// 3. 再给原来的数组前面加1(注意要从后往前加)
// 即可得到格雷码
public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        String[] str = null;
        if (n == 1) {
            str = new String[]{"0", "1"};
        } else {
            String[] tmp = getGray(n - 1);
            str = new String[2 * tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                str[i] = "0" + tmp[i];
                str[str.length - i - 1] = "1" + tmp[i];
            }
        }
        return str;
    }
}
