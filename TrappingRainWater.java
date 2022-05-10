package LeetCode;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    // TC -> O(N)
    // SC -> O(1)
    public static int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans += (leftMax - height[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += (rightMax - height[right]);
                right--;
            }
        }
        return ans;
    }

    // TC -> O(N) + O(N) + O(N) -> O(3N)
    // SC -> O(N) + O(N) -> O(2N)
    public static int trap_(int[] height) {
        int ans = 0;
        int n = height.length;
        int prex[] = new int[n];
        int suff[] = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            prex[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            suff[i] = max;
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(prex[i], suff[i]) - height[i];
        }
        return ans;
    }

    // TC -> O(N^2)
    // SC -> O(N)
    public static int trap__(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }
}
