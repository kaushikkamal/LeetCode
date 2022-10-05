// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

package LeetCode;

public class MaximumDifferenceBetweenNodeAndAncestor {
    private int helper(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }

        int left = helper(root.left, Math.min(min, root.val), Math.max(max, root.val));

        int right = helper(root.right, Math.min(min, root.val), Math.max(max, root.val));

        return Math.max(left, right);
    }

    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }
}
