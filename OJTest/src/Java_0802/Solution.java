package Java_0802;

/**
 * 大小为 K 且平均值大于等于阈值的子数组数目
 *
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 *
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 *
 * 示例 ：
 *
 * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * 输出：3
 * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。
 *      其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
 *
 */


public class Solution {
    // 思路: 使用滑动窗口简化思路
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // 第一步: 将前k个数字求和, 如果大于threshold * k, count++
        int sum = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= k * threshold) {
            count++;
        }
        // 第二步:滑动窗口, 将指针后移一位, 用后移一位的值减去移动之前的第一位的值
        for (int i = 0; i < arr.length - k; i++) {
            sum = sum + arr[i + k] - arr[i];
            if (sum >= k * threshold) {
                count++;
            }
        }
        return count;
    }
}
