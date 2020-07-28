package Java06_09;

// 找出n个数中最小的k个数

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    // 借助Arrays.sort() 来实现
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String[] a = sc.nextLine().split(" ");
            int arr[] = new int[a.length - 1];
            for (int i = 0; i < a.length - 1; i++) {
                arr[i] = Integer.valueOf(a[i]);
            }
            int k = Integer.valueOf(a[a.length - 1]);
            Arrays.sort(arr);
            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    // 借助快排来实现
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String[] a = sc.nextLine().split(" ");
            int arr[] = new int[a.length - 1];
            for (int i = 0; i < a.length - 1; i++) {
                arr[i] = Integer.valueOf(a[i]);
            }
            int k = Integer.valueOf(a[a.length - 1]);
            quickSort(arr, 0, arr.length - 1);
            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int index = qSortHelper(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    private static int qSortHelper(int[] arr, int left, int right) {
        int baseIndex = right;
        int base = arr[right];
        while (left < right) {
            while (left < right && arr[left] <= base) {
                left++;
            }
            while (left < right && arr[right] >= base) {
                right--;
            }
            swap(arr ,left, right);
        }
        swap(arr, left, baseIndex);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
