// https://www.naukri.com/code360/problems/merge-sort_920442

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 6, 1, 1, 2, 4 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        List<Integer> temp = new ArrayList<>();
        int p1 = start;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= end) {
            if (arr[p1] <= arr[p2]) {
                temp.add(arr[p1]);
                p1++;
            } else {
                temp.add(arr[p2]);
                p2++;
            }
        }

        while (p1 <= mid) {
            temp.add(arr[p1]);
            p1++;
        }

        while (p2 <= end) {
            temp.add(arr[p2]);
            p2++;
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp.get(i - start);
        }
    }
}
