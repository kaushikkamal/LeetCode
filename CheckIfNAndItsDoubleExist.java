package LeetCode;

import java.util.HashSet;

// https://leetcode.com/problems/check-if-n-and-its-double-exist/
public class CheckIfNAndItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) {
            if (set.contains(a * 2) || (a % 2 == 0 && set.contains(a / 2)))
                return true;
            set.add(a);
        }
        return false;
    }

    public boolean checkIfExist_(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
