// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

package LeetCode;

public class FlattenBinaryTreeToLinkedList {

    // Approach 1

    public void flatten_(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                TreeNode temp = cur.left;

                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    // Approach 2

    public TreeNode flatten(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }

        prev = flatten(root.right, prev);
        prev = flatten(root.left, prev);

        root.right = prev;
        root.left = null;
        prev = root;
        return prev;
    }

    public void flatten(TreeNode root) {
        flatten(root, null);
    }
}
