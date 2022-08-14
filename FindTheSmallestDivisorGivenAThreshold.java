// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

// TC -> O(NlogM)
// SC -> O(1)
package LeetCode;

public class FindTheSmallestDivisorGivenAThreshold {
    private boolean isValid(int[] nums, int mid, int threshold) {
        int rem = 0;

        for (int i : nums) {
            rem += Math.ceil((double) i / mid);
        }

        return rem <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = -1;
        int res = -1;

        for (int i : nums) {
            end = Math.max(end, i);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(nums, mid, threshold)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
