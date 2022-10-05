// https://leetcode.com/problems/delete-leaves-with-a-given-value/

package LeetCode;

public class DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null || target == 0)
            return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    private boolean helper(TreeNode cur, int target) {

        if (cur.left != null) {
            boolean left = helper(cur.left, target);
            if (left) {
                cur.left = null;
            }
        }

        if (cur.right != null) {
            boolean right = helper(cur.right, target);
            if (right) {
                cur.right = null;
            }
        }

        if (cur.left == null && cur.right == null && cur.val == target) {
            return true;
        }
        return false;
    }

    public TreeNode removeLeafNodes_(TreeNode root, int target) {
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }

        boolean isValid = helper(root, target);

        return isValid ? null : root;
    }
}
