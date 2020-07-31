package Java06_12;

// 构建乘积数组
// 思路: 就是B数组中包含A数组中除了i自己以外所有项的乘积
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        // 计算A[0]~A[i-1]的乘积
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        // 计算A[i+1]~A[n-1]的乘积
        int tmp = 1;
        for (int i = A.length - 2; i >= 0 ; i--) {
            tmp *= A[i + 1];
            B[i] *= tmp;
        }
        return B;
    }
}
