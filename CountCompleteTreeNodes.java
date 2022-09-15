// https://leetcode.com/problems/count-complete-tree-nodes/

package LeetCode;

public class CountCompleteTreeNodes {
    private int leftHeight(TreeNode root) {
        int count = 0;

        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int rightHeight(TreeNode root) {
        int count = 0;

        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = leftHeight(root);
        int right = rightHeight(root);

        if (left == right) {
            return (1 << left) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
