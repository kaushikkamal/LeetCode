// https://leetcode.com/problems/koko-eating-bananas/
package LeetCode;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;

        int res = -1;

        for (int i : piles) {
            end = Math.max(end, i);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int hourSpent = 0;

            for (int i : piles) {
                hourSpent += Math.ceil((double) i / mid);
            }

            if (hourSpent <= h) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
