package LeetCode;

public class LowestCommonAncestorOfABinaryTreeNodeMayNotBePresent {
    private TreeNode helper(TreeNode root, int[] B, int[] C) {
        if (root == null)
            return null;

        TreeNode left = helper(root.left, B, C);
        TreeNode right = helper(root.right, B, C);

        if (root.val == B[0] || root.val == C[0]) {
            B[0] = root.val == B[0] ? -1 : B[0];
            C[0] = root.val == C[0] ? -1 : C[0];
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }

    public TreeNode lca(TreeNode root, int B, int C) {
        int[] num1 = new int[] { B };
        int[] num2 = new int[] { C };

        TreeNode res = helper(root, num1, num2);

        if (res != null && num1[0] == -1 && num2[0] == -1) {
            return res;
        }
        return null;
    }
}
