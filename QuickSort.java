// https://www.naukri.com/code360/problems/quick-sort_983625

package LeetCode;

import java.util.List;

public class QuickSort {
    public static void swap(List<Integer> arr, int low, int high) {
        int temp = arr.get(low);
        arr.set(low, arr.get(high));
        arr.set(high, temp);
    }

    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (arr.get(i) <= pivot && i < high) {
                i++;
            }
            while (arr.get(j) > pivot && j > low) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    public static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qs(arr, low, pivot - 1);
            qs(arr, pivot + 1, high);
        }
    }

    // main
    public static List<Integer> quickSort(List<Integer> arr) {
        qs(arr, 0, arr.size() - 1);
        return arr;
    }

}
