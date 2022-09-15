package LeetCode;

public class DeleteNodeInABST {
    private TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        TreeNode temp = root.left;
        TreeNode cur = temp;

        while (temp.right != null) {
            temp = temp.right;
        }

        temp.right = root.right;
        return cur;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.val == key) {
            return helper(root);
        }

        TreeNode cur = root;

        while (cur != null) {
            if (key < cur.val) {
                if (cur.left != null && cur.left.val == key) {
                    cur.left = helper(cur.left);
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right != null && cur.right.val == key) {
                    cur.right = helper(cur.right);
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }
}
