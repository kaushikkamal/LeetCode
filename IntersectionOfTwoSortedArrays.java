package LeetCode;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {
    public static ArrayList<Integer> findIntersection(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                res.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 2, m = 8;
        int arr1[] = { 1, 35 };
        int arr2[] = { 6, 9, 13, 15, 20, 25, 29, 46 };

        System.out.println(findIntersection(arr1, arr2, n, m));
    }
}
