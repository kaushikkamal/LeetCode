// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

package LeetCode;

public class CountGoodNodesInBinaryTree {

    // Approach 1

    private void countGoodNodes(TreeNode root, int[] count, int max) {
        if (root == null)
            return;

        if (root.val >= max) {
            count[0]++;
        }

        countGoodNodes(root.left, count, Math.max(max, root.val));
        countGoodNodes(root.right, count, Math.max(max, root.val));
    }

    public int goodNodes(TreeNode root) {
        int[] count = new int[] { 0 };

        countGoodNodes(root, count, Integer.MIN_VALUE);

        return count[0];
    }

    // Approach 2

    private int countGoodNodes(TreeNode root, int max) {
        if (root == null)
            return 0;

        int res = 0;

        if (root.val >= max) {
            res++;
        }

        res += countGoodNodes(root.left, Math.max(max, root.val));
        res += countGoodNodes(root.right, Math.max(max, root.val));

        return res;
    }

    public int goodNodes_(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
}
