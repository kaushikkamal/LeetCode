// https://leetcode.com/problems/sum-of-left-leaves/

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            ans += sumOfLeftLeaves(root.right);
        }

        return ans;
    }

    public int sumOfLeftLeaves_(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.left != null) {
                if (temp.left.left == null && temp.left.right == null) {
                    count += temp.left.val;
                } else {
                    q.offer(temp.left);
                }
            }

            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
        return count;
    }
}
