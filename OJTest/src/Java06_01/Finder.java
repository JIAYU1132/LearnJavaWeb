package Java06_01;

// 返回数组中第 K 大的值
public class Finder {

    private static int k;
    public static int findKth(int[] a, int n, int K) {
        // write code here
        k = a.length - K;
        sortHelper(a, 0, n - 1);
        return a[k];
    }

    private static void sortHelper(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (k == index) {
            return;
        } else if (k < index) {
            sortHelper(arr, left, index - 1);
        } else {
            sortHelper(arr, index + 1, right);
        }
    }
    private static int partition(int[] arr, int left, int right) {
        int base = arr[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[i] <= base) {
                i++;
            }
            while (i < j && arr[j] >= base) {
                j--;
            }
            sweap(arr, i , j);
        }
        sweap(arr, right, i);
        return i;
        }

    private static void sweap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 5, 6, 7, 3, 5, 9, 1};
        findKth(arr, 9, 4);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(findKth(arr, 9, 4));
    }
}

