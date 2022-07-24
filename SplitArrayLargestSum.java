// https://leetcode.com/problems/split-array-largest-sum/

// TC -> O(Mlog(n))
// SC -> O(1)

public class SplitArrayLargestSum {
    private static int partsRequired(int[] nums, int mid) {
        int sum = 0;
        int totalParts = 1;

        for (int i : nums) {
            sum += i;
            if (sum > mid) {
                sum = i;
                totalParts++;
            }
        }

        return totalParts;
    }

    public static int splitArray(int[] nums, int m) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        int res = -1;

        for (int i : nums) {
            start = Math.max(start, i);
            end += i;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int parts = partsRequired(nums, mid);

            if (parts <= m) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int m = 1;
        System.out.println(splitArray(nums, m));
    }
}
