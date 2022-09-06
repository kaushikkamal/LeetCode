https://leetcode.com/problems/binary-tree-maximum-path-sum/

    package LeetCode;

    public class BinaryTreeMaximumPathSum {

        public int helper(TreeNode root, int[] maxPath) {
            if (root == null) {
                return 0;
            }
            
            int maxL = Math.max(0, helper(root.left, maxPath));
            int maxR = Math.max(0, helper(root.right, maxPath));

            maxPath[0] = Math.max(maxPath[0], root.val + maxL + maxR);

            return root.val + Math.max(maxL, maxR);
        }

        public int maxPathSum(TreeNode root) {
            int[] maxPath = new int[1];
            maxPath[0] = Integer.MIN_VALUE;

            helper(root, maxPath);

            return maxPath[0];
        }
    }
