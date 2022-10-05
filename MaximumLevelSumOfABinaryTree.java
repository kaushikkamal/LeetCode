// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        int resLevel = 1;
        int minSum = root.val;
        int curLevel = 1;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            while (size-- > 0) {
                TreeNode temp = q.poll();
                sum += temp.val;

                if (temp.left != null) {
                    q.offer(temp.left);
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }

            if (sum > minSum) {
                resLevel = curLevel;
                minSum = sum;
            }
            curLevel++;
        }
        return resLevel;
    }
}
