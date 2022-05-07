https://leetcode.com/problems/maximum-depth-of-binary-tree/
    
    package LeetCode;

    public class MaximumDepthOfBinaryTree {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return Math.max(left, right) + 1;
        }
    }
