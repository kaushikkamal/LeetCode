package LeetCode;

import java.util.Arrays;

public class MergeSortedArrayWithConstantSpace {
    private static void merge(int[] arr1, int[] arr2, int l1, int l2) {
        int i, k;

        for (i = 0; i < l1; i++) {
            if (arr1[i] > arr2[0]) {
                int temp = arr2[0];
                arr2[0] = arr1[i];
                arr1[i] = temp;

                int first = arr2[0];

                for (k = 1; k < l2 && arr2[k] < first; k++) {
                    arr2[k - 1] = arr2[k];
                }

                arr2[k - 1] = first;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 4, 7, 8, 10};
        int arr2[] = {2, 3, 9};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("after sorting");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }


}
