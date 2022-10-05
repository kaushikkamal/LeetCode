// https://leetcode.com/problems/find-bottom-left-tree-value/

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    // iterative

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            root = q.poll();

            if (root.right != null) {
                q.offer(root.right);
            }

            if (root.left != null) {
                q.offer(root.left);
            }
        }
        return root.val;
    }

    // recursive

    private void helper(TreeNode root, int[] res, int level, int[] maxLevel) {
        if (root == null)
            return;

        helper(root.left, res, level + 1, maxLevel);
        helper(root.right, res, level + 1, maxLevel);

        if (level > maxLevel[0]) {
            res[0] = root.val;
            maxLevel[0] = level;
        }
    }

    public int findBottomLeftValue_(TreeNode root) {
        int[] res = new int[] { root.val };
        int[] maxLevel = new int[1];
        int level = 0;

        helper(root, res, level, maxLevel);

        return res[0];
    }
}
