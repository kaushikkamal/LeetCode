// https://leetcode.com/problems/minimum-depth-of-binary-tree/

package LeetCode;

public class MinimumDepthOfBinaryTree {
    private int height(TreeNode node) {
        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);

        if (left == 0 || right == 0) {
            return 1 + left + right;
        }

        return 1 + Math.min(left, right);
    }

    public int minDepth(TreeNode root) {
        return height(root);
    }
}
