package Java_0725;

// 顺时针打印矩阵

/**
 * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
 *
 * 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
 *
 * 测试样例：
 * [[1,2],[3,4]],2,2
 * 返回：[1,2,4,3]
 */
public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int[] arr = new int[n * m];
        if (mat.length == 0) {
            return arr;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int startX = 0;
        int startY = 0;
        int endX = n - 1;
        int endY = m - 1;
        while (startX <= endX && startY <= endY) {
            // 如果在最后一行
            if (startX == endX) {
                for(; j <= endY; j++,k++) {
                    arr[k] = mat[startX][j];
                }
                return arr;
            }
            //如果在最后一列
            if (startY == endY) {
                for(; i <= endX; i++, k++) {
                    arr[k] = mat[i][startY];
                }
                return arr;
            }
            //将矩阵上边除右顶点添加到返回的数组中
            for( ; j < endY ; j++,k++){
                arr[k] = mat[i][j];
            }
            //将矩阵右边除边下顶点添加到返回的数组中
            for( ; i < endX ; i++,k++){
                arr[k] = mat[i][j];
            }
            //将矩阵下边除边左顶点添加到返回的数组中
            for( ; j > startX ; j--,k++){
                arr[k] = mat[i][j];
            }
            //将矩阵左边除边上顶点添加到返回的数组中
            for( ; i > startY ; i--,k++){
                arr[k] = mat[i][j];
            }

            i++;
            j++;
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return arr;
    }
}
