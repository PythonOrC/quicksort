import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 1, 4 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivotIdx = low + (int) (Math.random() * (high - low + 1));
        int pivot = arr[pivotIdx];
        swap(arr, pivotIdx, low);

        int left = low + 1;
        int right = high;

        while (left <= right) {
            if (arr[left] <= pivot) {
                left++;
            } else if (arr[right] >= pivot) {
                right--;
            } else {
                swap(arr, left, right);
                left++;
                right--;
                // swap(arr, left++, right--);
            }
        }

        swap(arr, low, right);
        return right;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(arr, low, high);
            quickSort(arr, low, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, high);
        }
    }
}