package Java_0723;

import java.util.*;
// 数组中出现超过一半的数字
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length / 2]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return array[array.length / 2];
        } else {
            return 0;
        }
    }
}