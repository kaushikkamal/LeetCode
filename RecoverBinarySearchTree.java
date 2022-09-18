// https://leetcode.com/problems/recover-binary-search-tree/

package LeetCode;

public class RecoverBinarySearchTree {
    TreeNode first = null;
    TreeNode mid = null;
    TreeNode last = null;
    TreeNode prev = null;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (root.val < prev.val) {
            if (first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && mid != null) {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }
}
