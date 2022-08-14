// https://leetcode.com/problems/kth-missing-positive-number/

// TC -> O(N)
// SC -> O(1)
package LeetCode;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int i = 1;
        int j = 0;
        int res = -1;

        while (k != 0) {
            if (i != arr[j]) {
                res = i;
                k--;
            } else {
                j++;
            }
            i++;
            if (j == arr.length) {
                return arr[arr.length - 1] + k;
            }
        }
        return res;
    }
}
