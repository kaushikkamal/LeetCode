// https://leetcode.com/problems/increasing-order-search-tree/

package LeetCode;

public class IncreasingOrderSearchTree {
    private TreeNode inorder(TreeNode root, TreeNode tail) {
        if (root == null)
            return tail;

        TreeNode res = inorder(root.left, root);

        root.left = null;
        root.right = inorder(root.right, tail);

        return res;
    }

    public TreeNode increasingBST(TreeNode root) {
        return inorder(root, null);
    }
}
