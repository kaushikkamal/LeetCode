// https://leetcode.com/problems/average-of-levels-in-binary-tree/

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    private void calculateAverage(TreeNode root, Queue<TreeNode> q, List<Double> ans) {
        if (root == null) {
            return;
        }

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int tempSize = size;
            double sum = 0.0;

            while (tempSize-- > 0) {
                TreeNode temp = q.poll();

                sum += temp.val;

                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }

            ans.add(sum / size);
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        calculateAverage(root, q, ans);

        return ans;
    }
}
