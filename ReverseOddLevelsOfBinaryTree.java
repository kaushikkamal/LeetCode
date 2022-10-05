// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/

package LeetCode;

public class ReverseOddLevelsOfBinaryTree {
    private void helper(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) {
            return;
        }

        if ((level & 1) == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        helper(left.left, right.right, level + 1);
        helper(left.right, right.left, level + 1);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        helper(root.left, root.right, 1);
        return root;
    }
}
