package Java0821;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 4, 6, 4, 5, 9, 7};
//        insertSort(arr);
//        selectSort(arr);
//        heapSort(arr);
//        bubbleSort(arr);
//        quickSort(arr);
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    // 插入排序
    public static void insertSort(int[] arr) {
        for (int bound = 1; bound < arr.length; bound++) {
            int v = arr[bound];
            int cur = bound - 1;
            for (;cur >= 0; cur--) {
                if (arr[cur] > v) {
                    arr[cur + 1] = arr[cur];
                } else {
                    break;
                }
            }
            arr[cur + 1] = v;
        }
    }

    // 2. 选择排序
    private static void selectSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = bound + 1; cur < arr.length; cur++) {
                if (arr[cur] < arr[bound]) {
                    int temp = arr[cur];
                    arr[cur] = arr[bound];
                    arr[bound] = temp;
                }
            }
        }
    }

    // 堆排序
    private static void heapSort(int[] arr) {
        createHeap(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, 0, arr.length - 1 - i);
            shifDown(arr, arr.length - 1 - i, 0);
        }
    }

    private static void createHeap(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            shifDown(arr, arr.length, i);
        }
    }

    private static void shifDown(int[] arr, int heapLength, int index) {
        int parent = index;
        int  child = 2 * parent + 1;
        while (child < heapLength) {
            if (child + 1 < heapLength && arr[child] < arr[child + 1]) {
                child = child + 1;
            }
            if (arr[child] > arr[parent]) {
                swap(arr, child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 冒泡排序
    private static void bubbleSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > 0; cur--) {
                if (arr[cur] < arr[cur - 1]) {
                    swap(arr, cur, cur - 1);
                }
            }
        }
    }

    // 快排
    private static void quickSort(int[] arr) {
        quickSortHelp(arr, 0, arr.length - 1);
    }

    private static void quickSortHelp(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        quickSortHelp(arr, left, index - 1);
        quickSortHelp(arr, index + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int base = arr[right];
        while (i < j) {
            while (i < j && arr[i] <= base) {
                i++;
            }
            while (i < j && arr[j] >= base) {
                j--;
            }
            swap(arr, i, j);
        }
        swap(arr, i, right);
        return i;
    }

    // 归并
    private static void mergeSort(int[] arr) {
        mergeSortHelp(arr, 0, arr.length);
    }

    private static void mergeSortHelp(int[] arr, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = (high + low) / 2;
        mergeSortHelp(arr, low, mid);
        mergeSortHelp(arr, mid, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] out = new int[high - low];
        int outIndex = 0;
        int cur1 = low;
        int cur2 = mid;
        while (cur1 < mid && cur2 < high) {
            if (arr[cur1] <= arr[cur2]) {
                out[outIndex++] = arr[cur1++];
            } else {
                out[outIndex++] = arr[cur2++];
            }
        }
        while (cur1 < mid) {
            out[outIndex++] = arr[cur1++];
        }
        while (cur2 < high) {
            out[outIndex++] = arr[cur2++];
        }
        for (int i = 0; i < high - low; i++) {
            arr[low + i] = out[i];
        }
    }
}
