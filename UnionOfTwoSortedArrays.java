// https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

package LeetCode;

import java.util.ArrayList;

public class UnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                if (res.size() == 0 || arr1[i] != res.get(res.size() - 1)) {
                    res.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                if (res.size() == 0 || arr1[i] != res.get(res.size() - 1)) {
                    res.add(arr1[i]);
                }
                i++;
            } else {
                if (res.size() == 0 || arr2[j] != res.get(res.size() - 1)) {
                    res.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n) {
            if (res.size() == 0 || arr1[i] != res.get(res.size() - 1)) {
                res.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {
            if (res.size() == 0 || arr2[j] != res.get(res.size() - 1)) {
                res.add(arr2[j]);
            }
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 2, m = 8;
        int arr1[] = { 1, 35 };
        int arr2[] = { 6, 9, 13, 15, 20, 25, 29, 46 };

        System.out.println(findUnion(arr1, arr2, n, m));
    }
}
