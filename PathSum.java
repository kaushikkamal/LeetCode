// https://leetcode.com/problems/path-sum/

package LeetCode;

public class PathSum {
    private boolean preorder(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int newTarget = targetSum - root.val;
        if (newTarget == 0 && root.left == null && root.right == null) {
            return true;
        }

        return preorder(root.left, newTarget) || preorder(root.right, newTarget);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return preorder(root, targetSum);
    }
}
