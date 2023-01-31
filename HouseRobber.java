// https://leetcode.com/problems/house-robber/description/

package LeetCode;

public class HouseRobber {
    public int rob(int[] nums) {
        int prev2 = nums[0];
        int prev1 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int picked = nums[i];
            if (i > 1) {
                picked += prev2;
            }
            int notPicked = prev1;
            int cur = Math.max(picked, notPicked);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
