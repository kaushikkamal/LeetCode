// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

package LeetCode;

public class SumOfRootToLeafBinaryNumbers {
    private int helper(TreeNode root, int val) {
        if (root == null)
            return 0;

        val = 2 * val + root.val;

        if (root.left == null && root.right == null) {
            return val;
        }

        return helper(root.left, val) + helper(root.right, val);
    }

    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }
}
