// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

// TC -> O(N)
// SC -> O(1)
package LeetCode;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                max = Math.max(max, count);
            } else if (c == ')') {
                count--;
            }
        }
        return max;
    }
}
