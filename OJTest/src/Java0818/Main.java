package Java0818;
import java.util.*;

public class Main {

        /**
         *
         * @param str string字符串
         * @return string字符串
         */
        public static String compress (String str) {
            // write code here
           StringBuilder sb = new StringBuilder();
           int count = 0;
            for (int i = 0; i < str.length(); i++) {
                count++;
                char c = str.charAt(i);
                if (i + 1 >= str.length() || c != str.charAt(i + 1)) {
                    sb.append(c);
                    sb.append(count);
                    count = 0;
                }
            }
            if (sb.length() > str.length()) {
                return str;
            } else {
                return sb.toString();
            }
        }

    public static void main(String[] args) {
        String s = "abbccdddaaaa";
        System.out.println();
    }


    public int[][] convert (int[][] matrix) {
            Set<Integer> set = new HashSet<>();
            set.add(1);
        // write code here
        int[][] arr = new int[matrix.length][matrix[0].length];
        int index = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            arr[index] = matrix[i];
            index++;
        }
        return arr;
    }


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int row = 0;
        int col = cols;
        while (row <= rows && col >= 0) {
            int temp = matrix[row][col];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}
