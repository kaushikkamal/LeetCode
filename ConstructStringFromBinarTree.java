// https://leetcode.com/problems/construct-string-from-binary-tree/

package LeetCode;

public class ConstructStringFromBinarTree {
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(String.valueOf(root.val));

        if (root.left == null && root.right == null) {
            return;
        }

        sb.append("(");
        preorder(root.left, sb);
        sb.append(")");

        if (root.right != null) {
            sb.append("(");
            preorder(root.right, sb);
            sb.append(")");
        }
    }

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        preorder(root, sb);

        return sb.toString();
    }
}
