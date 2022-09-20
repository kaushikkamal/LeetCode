// https://leetcode.com/problems/diameter-of-binary-tree/

package LeetCode;

public class DiameterOfBinaryTree {

    // # Optimal
    private int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left, diameter);
        int right = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameter[0] = 0;

        height(root, diameter);

        return diameter[0];
    }

    // # Brute Force

    public class DiameterOfBinaryTree_ {
        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            return 1 + Math.max(left, right);
        }

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int cur = height(root.left) + height(root.right);
            int left = diameterOfBinaryTree(root.left);
            int right = diameterOfBinaryTree(root.right);

            return Math.max(cur, Math.max(left, right));
        }
    }
}