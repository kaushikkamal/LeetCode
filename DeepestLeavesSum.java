// https://leetcode.com/problems/deepest-leaves-sum/

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            count = 0;

            while (size-- > 0) {
                TreeNode temp = q.poll();
                count += temp.val;

                if (temp.left != null) {
                    q.offer(temp.left);
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }
        return count;
    }

    // Recursive

    private void helper(TreeNode root, int curLevel, int[] maxDepth, int[] sum) {
        if (root == null)
            return;

        if (curLevel > maxDepth[0]) {
            sum[0] = root.val;
            maxDepth[0] = curLevel;
        } else if (curLevel == maxDepth[0]) {
            sum[0] += root.val;
        }

        helper(root.left, curLevel + 1, maxDepth, sum);
        helper(root.right, curLevel + 1, maxDepth, sum);

    }

    public int deepestLeavesSum_(TreeNode root) {
        int[] maxDepth = new int[] { 0 };
        int[] sum = new int[] { 0 };

        helper(root, 0, maxDepth, sum);

        return sum[0];
    }
}
