package Java_0715;

// 二维数组打印

/**
 * 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
 *
 * 给定一个二位数组arr及题目中的参数n，请返回结果数组。
 *
 * 测试样例：
 * [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
 * 返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 */
public class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] res = new int[n * n];
        int index = 0;
        int row = 0;
        int col = n - 1;
        while (row < n) {
            int i = row;
            int j = col;
            while (i < n && j < n) {
                res[index++] = arr[i++][j++];
            }
            // 打印上半部分就是col大于0的情况, 如果col等于0了, 就说明上半部分打印完了
            // 此时就应该更新row来打印
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return res;
    }
}
