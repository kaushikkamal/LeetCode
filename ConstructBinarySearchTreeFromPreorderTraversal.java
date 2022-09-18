// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

package LeetCode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode cur = root;

            while (cur != null) {
                if (preorder[i] < cur.val) {
                    if (cur.left == null) {
                        cur.left = new TreeNode(preorder[i]);
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right == null) {
                        cur.right = new TreeNode(preorder[i]);
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }
        return root;
    }
}
