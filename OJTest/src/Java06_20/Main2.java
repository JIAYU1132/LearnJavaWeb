package Java06_20;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//单调栈结构
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] right = new int[arr.length];
            int[] left = new int[arr.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < arr.length; i++) {
                while(!stack.empty() && arr[i] < arr[stack.peek()]) {
                    int tmp = stack.pop();
                    if (stack.isEmpty()) {
                        left[tmp] = -1;
                    } else {
                        left[tmp] = stack.peek();
                    }
                    right[tmp] = i;
                }
                stack.push(i);
            }

            while(!stack.empty()) {
                int tmp = stack.pop();
                if (stack.isEmpty()) {
                    left[tmp] = -1;
                } else {
                    left[tmp] = stack.peek();
                }
                right[tmp] = -1;
            }

            for(int i = 0; i < arr.length; i++) {
                System.out.println(left[i] + " " + right[i]);
            }
        }
    }
}
