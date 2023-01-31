// https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?leftPanelTab=0

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {

    // Space Optimized Tabulation
    // TC -> O(N)
    // SC -> O(1)

    private static int calculate(int n, ArrayList<Integer> nums) {
        int prev2 = nums.get(0);
        int prev1 = nums.get(0);

        for (int i = 1; i < n; i++) {
            int picked = nums.get(i);
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

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        return calculate(n, nums);
    }

    // Tabulation
    // TC -> O(N)
    // SC -> O(N)

    private static int calculate_(int n, ArrayList<Integer> nums) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);

        for (int i = 1; i < n; i++) {
            int picked = nums.get(i);
            if (i > 1) {
                picked += dp[i - 2];
            }
            int notPicked = dp[i - 1];
            dp[i] = Math.max(picked, notPicked);
        }
        return dp[n - 1];
    }

    public static int maximumNonAdjacentSum_(ArrayList<Integer> nums) {
        int n = nums.size();
        return calculate_(n, nums);
    }

    // Memoization
    // TC -> O(N)
    // SC -> O(N) + O(N)

    private static int calculate__(int n, ArrayList<Integer> nums, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return dp[0];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int picked = nums.get(n) + calculate__(n - 2, nums, dp);
        int notPicked = calculate__(n - 1, nums, dp);

        dp[n] = Math.max(picked, notPicked);
        return dp[n];
    }

    public static int maximumNonAdjacentSum__(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);

        return calculate__(n - 1, nums, dp);
    }

    // Recursive
    // TC -> O(2^n)
    // SC -> O(N)

    private static int calculate___(int n, ArrayList<Integer> nums) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return nums.get(0);
        }

        int picked = nums.get(n) + calculate___(n - 2, nums);
        int notPicked = calculate___(n - 1, nums);

        return Math.max(picked, notPicked);
    }

    public static int maximumNonAdjacentSum___(ArrayList<Integer> nums) {
        int n = nums.size();

        return calculate___(n - 1, nums);
    }
}
