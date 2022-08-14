// https://leetcode.com/problems/arranging-coins/

// TC -> O(log(n))
// SC -> O(1)
package LeetCode;

public class ArrangingCoins {

    // Consider as Infinite Sorted Array Problem

    public int arrangeCoins(int n) {
        long start = 1;
        long end = 2;
        long res = 1;

        while (n > end) {
            res++;
            start = end + 1;
            end = start + res;
        }
        return (int) res;
    }
}
